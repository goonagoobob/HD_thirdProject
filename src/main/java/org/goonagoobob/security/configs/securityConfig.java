package org.goonagoobob.security.configs;

import org.goonagoobob.security.handler.CustomLoginSuccessHandler;
import org.goonagoobob.security.provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableWebSecurity

public class securityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService; //이 모양으로 반납해줄 .,,, bean 설정해놓음
	
	//AuthenticationProvider	
	 @Bean
	   public AuthenticationProvider authenticationProvider() {
	      return new CustomAuthenticationProvider();
	   }

	// AuthenticationManagerBuilder	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		//우리가 만든 userDetails 넣어주기
		auth.userDetailsService(userDetailsService); 
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//webIgnore 설정 : .js/css/image 파일 등 보안 필터를 적용할 필요가 없는 리소스를 설정
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}

	// 4. 스프링 시큐리티 규칙
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		
		http.authorizeHttpRequests().antMatchers("/member/join").permitAll()
			.antMatchers("/member/login").permitAll()
			.antMatchers("/myPage/myPage").permitAll()
			.antMatchers("/member/findIdPassword").permitAll()
			.antMatchers("/member/findIdResult").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/product/productDetail").permitAll()
			.antMatchers("product/productList").permitAll()
			.anyRequest().authenticated(); // csrf 보안 설정 비활성화
		// .addFilter(jwtAuthorizationFilter()) 해야함

		http.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/member/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(new CustomLoginSuccessHandler());
		
		http.logout()
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true);
		
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}