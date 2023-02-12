package org.goonagoobob.controller.member;

import javax.servlet.http.HttpServletResponse;

import org.goonagoobob.domain.member.memberJoin;
import org.goonagoobob.service.member.memberService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;

@RestController
@Log4j2
@RequestMapping("/memberRestAPI")
@RequiredArgsConstructor
public class memberRestController {
	private final memberService service;
	
	
	/*
	 * @PostMapping(value = "/joinMemberAccount", consumes = "application/json",
	 * produces = { MediaType.APPLICATION_JSON_VALUE })
	 */
	@RequestMapping(value="/joinMemberAccount", method=RequestMethod.POST)
	public String joinMember(HttpServletResponse response, @RequestBody memberJoin mj) throws Exception {
		System.out.println(mj);
		System.out.println("password?? " + mj.getMpassword());
		
		int num = service.joinMemberAccount(mj);
		System.out.println(num);
		if (num == 1) {
			//왜 redirect 안되지 ,, 
			return "redirect:/";
		}
		
		else {
			return "/member/join";
		}
	}

	@RequestMapping(value="/idDoubleCheck", method=RequestMethod.POST)
	@ResponseBody
	public int idDoubleCheck(HttpServletResponse response, @RequestBody JSONObject element) throws Exception{
		
		System.out.println(element);
		String mid = element.get("mid").toString();
		if(service.selectById(mid) == null) {
			return 1;
		}
		
		return 0;
	}

}