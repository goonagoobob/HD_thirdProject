package org.goonagoobob.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class mainController {
	@GetMapping("/")
	private String index() {
		return "/main";
	}
	
	@GetMapping(value="/login")
	public String login() throws Exception {
		return "/member/login";
	}
}
