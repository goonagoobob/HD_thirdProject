package org.goonagoobob.controller.order;

import java.util.Date;

import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order/")
@RestController
public class orderRestController {

	@Autowired
	private orderService orderService;

	@GetMapping("/orderPay")
	public void orderPay(orderVO orders) {
		System.out.println(orders);
		System.out.println("order 결제까지 옴");

		orders.setOdate(new Date());
//		orderService.insert(orders);
	}
}
