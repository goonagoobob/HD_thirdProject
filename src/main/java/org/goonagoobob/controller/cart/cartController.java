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
//		String psid = "TM2CAWPC270W_SG_64";
//		List<cartcolorVO> cList = service.colorList(mid, psid);
//		model.addAttribute("cList", cList);
	}
	
	  //psid 상품의 색상 종류 뿌려주기
//	  
//	  @PostMapping("/list") 
//	  public void cartColor(Principal prin, @RequestParam("psid") String psid, Model model) {
//		  log.info("postcartList controller...");
//		  String mid = prin.getName(); System.out.print("mid" + mid + " psid" + psid);
//		  List<cartcolorVO> cList = service.colorList(mid, psid);
//		  log.info(cList);
//		  model.addAttribute("cList", cList); 
//	  }
//	 
}
