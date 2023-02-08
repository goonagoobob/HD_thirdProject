package org.goonagoobob.controller.myPage;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/myPage/")
@AllArgsConstructor
@Log4j2
public class myPageController {
	
	@Autowired
	private orderService service;
	
	@GetMapping("/myPage")
	public void myPage() {
		
	}
	
	@GetMapping("/passwordCheck")
	public void passwordCheck() {
		
	}
	
	@GetMapping("/changeUserInfo")
	public void changeUserInfo() {
		
	}
	
	@GetMapping("/passwordChange")
	public void passwordChange() {
	}
	
	@GetMapping(value = "/orderList")
	public void getList(Criteria cri, Model model, Authentication authentication) {
		log.info("getList............");
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String mid = userDetails.getUsername();
		System.out.println("controller mid " + mid);
		model.addAttribute("orderList", service.getList(cri, mid));
	}

}
