/*********************************
 * @function : 주문에 관한 Controller
 * @author : 차민수
 * @Date : Jan 31. 2023. ~ Feb 13.2023
 * 주문 내역 조회 기능 구현 Feb 09.2023
 * 주문 취소 기능 구현 Feb 10. 2023
 * 주문서에 주문 상품 정보를 조회하는 기능 구현 Feb 11. 2023
 * 주문 하기 기능 구현 Feb 11. 2023
 *********************************/
package org.goonagoobob.controller.order;

import java.util.ArrayList;
import java.util.List;

import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;
import org.goonagoobob.service.member.memberService;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/order/")
public class orderController {

	@Autowired
	private orderService orderService;
	
	@Autowired
	private memberService memberService;
	
	// 주문번호를 통해 주문 취소를 할 상품 리스트를 조회하는 Controller
	@GetMapping("/cancel")
	public void orderCancelList(@RequestParam(value = "oid") String oid, Model model) {
		log.info("orderCancel controller");
		log.info("oid" + oid);
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String mid = loggedInUser.getName();
		model.addAttribute("removeList", orderService.orderRemoveList(mid, oid));
		model.addAttribute("username", mid);
	}
	
	// 주문 취소 페이에 버튼 클릭에 따른 주문 취소를 하는 Controller (주문 취소 후, 주문 취소가 되었는지 확인하기 위해 주문 내역 페이지로 리다이렉트)
	@PostMapping("/cancel")
	public String orderCancel(@RequestParam(value = "oid") String oid, orderVO orderVO, RedirectAttributes rttr) {
		log.info("주문 취소 컨트롤러까지 옴");
		log.info("주문 취소 => 주문 상태를 주문 취소로 변경, 주문 번호 :" + oid);
		int result = orderService.orderRemove(oid);
		
		if (result != 0) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/myPage/orderList";
	}
	
	// 장바구니 혹은 상품 상세 페이지에서 '구매하기' 버튼 클릭에 따라서 상품 정보들을 조회하는 주문서로 이동하는 페이지를 받은 Controller
	// Model 에 주문한 유저의 정보, 주문할 상품 정보 리스트, 각 상품에 따른 상품 갯수를 함께 보내줌
	@GetMapping("/form")
	public void orderForm(@RequestParam(value = "psid",required = false) List<String> psid, @RequestParam(value="pamount",required = false) List<Integer> pamount, Model model) {
		log.info("orderForm controller");
		List<productDetailVO> orderList = new ArrayList<productDetailVO>();
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String userMid = loggedInUser.getName();
			for (String id : psid) {
			System.out.println(id);
			orderList.add(orderService.orderProduct(id));
		}
		System.out.println("주문서 컨트롤러까지 옴");
		
		model.addAttribute("directOrderList", orderList);
		model.addAttribute("username", memberService.selectById(userMid));
		model.addAttribute("pamount", pamount);
	}
	
	
}