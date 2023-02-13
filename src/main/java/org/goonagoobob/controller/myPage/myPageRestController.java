package org.goonagoobob.controller.myPage;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.goonagoobob.service.member.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;

@RestController
@Log4j2
@RequestMapping("/myPageRestAPI")
public class myPageRestController {
	
	@Autowired
	private memberService service;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@RequestMapping(value="/emailDoubleCheck", method=RequestMethod.POST)
	@ResponseBody
	public int emailDoubleCheck(Principal principal, HttpServletResponse response, @RequestBody String email) throws Exception {
		
		String mid = principal.getName();
		
		System.out.println(mid + ",  " + email);
		
		int num = service.emailDoubleCheck(mid, email);
		System.out.println("num" + num);
		return num;
	}
	
	
	@RequestMapping(value="/memberOutForm", method=RequestMethod.POST)
	@ResponseBody
	public int memberOutForm(Principal principal, HttpServletResponse response, @RequestBody String element) throws Exception {
		System.out.println(element);
		String mid = principal.getName();
		int num = service.memberOut(mid);
		System.out.println("num" + num);
		SecurityContextHolder.clearContext();
		return num;
	}
	
	@RequestMapping(value="/changePasswordForm", method=RequestMethod.POST)
	@ResponseBody
	public int changePasswordForm(Principal principal, HttpServletResponse response, @RequestBody JSONObject element) throws Exception{
		System.out.println(element.getClass());
		
		String originPassword = element.get("originPassword").toString();
		String newPassword = element.get("newPassword").toString();
		String newPasswordCheck = element.get("newPasswordCheck").toString();
		System.out.println(originPassword + "," + newPassword + "," + newPasswordCheck);
		String mid = principal.getName();
		System.out.println("사용자 로그인 정보: " + mid);
		
		
		//1. password 맞는지 확인
		System.out.println(service.checkPassword(mid));
		String mpassword = service.checkPassword(mid);
		System.out.println(mpassword);
	
		if(passwordEncoder.matches(originPassword, mpassword)){
			//1. 기존 비밀번호가 맞는지 확인
			if(newPassword.equals(newPasswordCheck)) {
				System.out.println(service.changePassword(mid, newPassword));
				return 1; //새 비밀번호 & 새 비밀번호 확인 같음 & 성공
			}
			else {
				return -2;
			}
		}
		else {
			//1-1. 기존 비밀번호가 맞지 않음
			System.out.println("기존 비밀번호가 틀림");
			return -1;
		}
		
	}
}
