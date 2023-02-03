package org.goonagoobob.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/cart/")
public class cartController {
	
	@GetMapping("/list")
	public void cartList() {
		log.info("cartList controller");
	}
}
