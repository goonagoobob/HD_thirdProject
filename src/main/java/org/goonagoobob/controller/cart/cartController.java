package org.goonagoobob.controller.cart;

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.service.cart.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/cart/")
public class cartController {
	@Autowired
	private cartService service;
	//cartList 불러오기
	@GetMapping("/list")
	public void cartList(Principal principal, Model model) {
		log.info("cartList controller");
		String mid = principal.getName();
		log.info(mid);
		List<cartVO> list = service.getCartList(mid);
		model.addAttribute("list", list);
		
	}
	
	@GetMapping("/insert")
	public void cartInsert( @RequestParam("username") String mid, Model model) {
		log.info("cartInsert controller");
	}
	// 장바구니 전체 삭제
	@PostMapping("/delete")
	public String cartDelete(Principal principal, Model model) throws Exception{
		log.info("cartDelete controller");
		String mid = principal.getName();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		
		int result = service.deleteCart(mid);
		log.info(result);
		model.addAttribute("result", result);
		
		return "cart/list";
	}
	
}
