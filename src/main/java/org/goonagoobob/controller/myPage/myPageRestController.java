package org.goonagoobob.controller.myPage;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.goonagoobob.service.member.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/myPageRestAPI")
public class myPageRestController {
	
	@Autowired
	private memberService service;
	
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
		return num;
	}
}
