
/*********************************
 * @function : 사용자 정보 인터페이스 구현
 * @author : 이세은
 * @Date : Feb 1. 2023
 * 
 *********************************/

package org.goonagoobob.security.service;

import java.util.ArrayList;
import java.util.List;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.mapper.member.memberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service("userDetailsService")
@Log4j2
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private memberMapper mM;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("username" + username);
		//id로 탖기
		memberAccount account = mM.selectById(username); //account 객체 얻어와서
		System.out.println(account);
		
		if(account == null) {
			System.out.println("null 이라고라 ????");
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
		//파라미터에 넣어줄 collection 타입으로 만들기
		List<GrantedAuthority> roles = new ArrayList<>();
		System.out.println(account.getMrole());
		
		roles.add(new SimpleGrantedAuthority(account.getMrole()));
		//account 클래스를 UserDetails 타입으로 변경
		memberAccountContext mAC = new memberAccountContext(account, roles); //타입을 만들어서
		
		return mAC; //보내줌
	}

	
}
