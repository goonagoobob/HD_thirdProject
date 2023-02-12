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
	
	@GetMapping("/complete")
	public void orderComplete() {
		log.info("orderComplete controller");
	}

	@GetMapping("/cancel")
	public void orderCancelList(@RequestParam(value = "oid") String oid, Model model) {
		log.info("orderCancel controller");
		log.info("oid" + oid);
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String mid = loggedInUser.getName();
		model.addAttribute("removeList", orderService.orderRemoveList(mid, oid));
		model.addAttribute("username", mid);
	}
	
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