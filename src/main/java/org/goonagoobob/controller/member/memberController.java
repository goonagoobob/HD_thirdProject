package org.goonagoobob.controller.member;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member")
public class memberController {
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
	
	@GetMapping("/findIdAndPassword")
	public void userFidIdAndPassword() {
		
	}
	
}
