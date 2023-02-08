package org.goonagoobob.controller.order;

import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	}
	
	@PostMapping("/cancel")
	public String orderCancel(@RequestParam(value = "oid") String oid, orderVO orderVO, RedirectAttributes rttr) {
		log.info("주문 취소 컨트롤러까지 옴");
		log.info("주문 취소 => 주문 상태를 주문 취소로 변경, 주문 번호 :" + oid);
		int result = orderService.orderRemove(oid);
		
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/myPage/orderList";
	}
	
	@GetMapping("/form")
	public void orderForm(Model model) {
		log.info("orderForm controller");
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String mid = loggedInUser.getName();
		model.addAttribute("username", mid);
	}

}