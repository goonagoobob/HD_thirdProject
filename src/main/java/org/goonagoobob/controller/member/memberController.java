package org.goonagoobob.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member/")
public class memberController {
	@GetMapping("/login")
	public void memberLogin() {
		
	}
	
	@GetMapping("/join")
	public void memberJoin() {
		
	}
	
	@GetMapping("/findIdAndPassword")
	public void userFidIdAndPassword() {
		
	}
}
