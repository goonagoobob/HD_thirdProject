package org.goonagoobob.controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/myPage/")
public class myPageController {
	
	@GetMapping("/passwordCheck")
	public void passwordCheck() {
		
	}
	
	
	@GetMapping("/changeUserInfo")
	public void changeUserInfo() {
		
	}
	
	@GetMapping("/passwordChange")
	public void passwordChange() {
	}
}
