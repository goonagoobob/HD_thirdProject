package org.goonagoobob.controller.cart;

import java.security.Principal;
import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.service.cart.cartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/cart/")
public class cartController {
	
	private cartService service;
	
	@GetMapping("/list")
	public void cartList(Principal principal, Model model) {
		log.info("cartList controller");
		String mid = principal.getName();
		List<cartVO> list = service.getCartList(mid);
		model.addAttribute("list", list);
		
	}
	
	@GetMapping("/insert")
	public void cartInsert( @RequestParam("username") String mid, Model model) {
		log.info("cartInsert controller");
	}
	
	@GetMapping("/delete")
	public void cartDelete( @RequestParam("username") String mid, Model model) {
		log.info("cartDelete controller");
	}
}
