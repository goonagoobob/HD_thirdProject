package org.goonagoobob.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	   @Autowired
	   private UserDetailsService userDetailsService;
	   @Autowired
	   private PasswordEncoder passwordEncoder;

	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String loginId = auth.getName();
		String passwd = (String)auth.getCredentials();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
		
		
		if(userDetails == null || !passwordEncoder.matches(passwd, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid password");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
