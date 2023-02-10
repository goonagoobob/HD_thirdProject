/*********************************
 * @function : Cart Controller 
 * @author : 김주혜
 * @Date : Feb 6. 2023
 * 카트목록 Controller 추가 Feb 6. 2023
 * 카트삭제 Controller 추가 Feb 7. 2023
 *********************************/


package org.goonagoobob.controller.cart;

import java.security.Principal;
import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.service.cart.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	/*
	 * @PostMapping("/insert") public String cartInsert(Principal principal, cartVO
	 * cart) { log.info("cartInsert controller"); String mid = principal.getName();
	 * String psid = cart.getPsid(); int pquantity = cart.getPquantity();
	 * log.info(psid); log.info(pquantity);
	 * 
	 * service.cartInsert(mid, psid, pquantity); return "/cart/list"; }
	 */
	@PostMapping("/list")
	public void cartColor(Principal prin, @RequestParam("rpsid") String psid, Model model) {
		log.info("postcartList controller...");
		String mid = prin.getName();
		System.out.print("mid" + mid + " psid" + psid);
		List<cartcolorVO> cList = service.colorList(mid, psid);
		model.addAttribute("cList", cList);
		
	}
//	  // 장바구니 전체 삭제
//	  
//	  @PostMapping("/delete") public String cartDelete(Principal principal, Model model) throws Exception{ 
//	  log.info("cartDelete controller"); 
//	  String mid = principal.getName(); 
//	  HttpHeaders headers = new HttpHeaders();
//	  headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
//	  int result = service.deleteCart(mid); log.info(result);
//	  model.addAttribute("result", result);
//	  return "cart/list"; 
//	 }













}
