package org.goonagoobob.controller.member;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member")
public class memberController {
	
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
		System.out.println(name);
		
		selYear = selYear.substring(2);
		System.out.println(selYear);
		System.out.println(selMonth);
		System.out.println(selDay);
		
		String mbirth = selYear + "/" + selMonth + "/" + selDay;
		System.out.println(mbirth);
		
		String mid = service.findId(name, mbirth);
		
		model.addAttribute("mname", name);
		model.addAttribute("mbirth", mbirth);
		model.addAttribute("mid", mid);
	}
	
}
