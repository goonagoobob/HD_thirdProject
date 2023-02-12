package org.goonagoobob.controller.member;

import java.security.Principal;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goonagoobob.components.mailComponents;
import org.goonagoobob.service.member.mailNansu;
import org.goonagoobob.service.member.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class memberController {
	private final mailComponents mailComponents;
	@Autowired
	private memberService service;
	
	@GetMapping("/login")
	public void memberLogin() {
		
	}
	
	@PostMapping("/login")
	public void loginInput(Principal principal, @RequestParam("username") String mid, @RequestParam("password") String mpassword) {
		System.out.println("mid");
		System.out.println("hello");
			
	}
	
	//로그인 실패 컨트롤러 setDeaultFailreURL()이 호출되었을 때 url을 매핑해줄 컨트롤러
	@GetMapping("/auth/login")
	public String login(@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "exception", required = false) String exception,
						Model model) {
		
		System.out.println("auth/login HERE !!!");
		
		System.out.println("error 내용 : " + error);
		System.out.println("exception 내용 : " + exception);
		/* 에러와 예외를 모델에 담아 view resolve */
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "/member/login"; //redirect이면 바로 넘어감 
	}
	
	
	@GetMapping("/join")
	public void memberJoin() {
		
	}

	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout");
		
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		/*
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * if (auth != null) { new SecurityContextLogoutHandler().logout(request,
		 * response, SecurityContextHolder.getContext().getAuthentication()); }
		 */
		return "redirect:/member/login";
	}
	
	@GetMapping("/findIdPassword")
	public void findIdPassword() {
		
	}
	
	@PostMapping("/findIdResult")
	public void findId(@RequestParam("iUserName") String name, @RequestParam("selYear") String selYear, @RequestParam("selMonth") String selMonth, @RequestParam("selDay") String selDay, Model model) {
		System.out.println("name: " + name);
		selYear = selYear.substring(2);
		System.out.println(selYear);
		System.out.println(selMonth);
		System.out.println(selDay);
		
		String mbirth = selYear + "/" + selMonth + "/" + selDay;
		System.out.println(mbirth);
		
		String mid = service.findId(name, mbirth);
		System.out.println("@@@@@@@@@" + mid);
		if(mid != null) {
			model.addAttribute("mname", name);
			model.addAttribute("mbirth", mbirth);
			model.addAttribute("mid", mid);
		}
		else {
			System.out.println("찾을 수 없음");
		}
	}
	
	@PostMapping("/findPasswordForm")
	public void findPassword(@RequestParam("pUserId") String Id, @RequestParam("pUserEmail") String email) throws MessagingException {
		System.out.println(Id);
		
		if(service.selectById(Id) != null) {
			//난수 생성
			String sendNansu = mailNansu.nanSu();		
			//이 값을 다시 update 합니다.
			service.changePassword(Id, sendNansu);
			//이후 메일로 보냅니다.
			mailComponents.sendMailTest(email, sendNansu);
		}	
		else {	
		}
		System.out.println(email);
	}
	
}
