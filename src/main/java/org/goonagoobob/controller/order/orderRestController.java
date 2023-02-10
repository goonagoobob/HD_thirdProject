package org.goonagoobob.controller.order;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.goonagoobob.domain.order.orderItemVO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/order/")
@RestController
@Log4j2
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
	
	@ResponseBody
	@PostMapping(value = "/form", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Integer> orderForm(@RequestBody Map<String, Object> map) {
		int result = 0;
		log.info("orderForm 에서 주문내역으로 이동");
		orderVO orderVO = new orderVO();
		orderVO.setOzipcode((String)map.get("ozipcode"));
		orderVO.setOaddress1((String)map.get("oaddress1"));
		orderVO.setOreceiver((String)map.get("oreceiver"));
		orderVO.setOphone((String)map.get("ophone"));
		orderVO.setOmemo((String)map.get("omemo"));
		orderVO.setOusedmileage(Integer.parseInt((String)map.get("ousedmileage")));
		orderVO.setObeforeprice(Integer.parseInt((String)map.get("obeforeprice")));
		orderVO.setObeforeprice(Integer.parseInt((String)map.get("oafterprice")));
		orderVO.setMid((String)map.get("mid"));
		orderVO.setPmcode((String)map.get("pmcode"));
		orderVO.setOaddress2((String)map.get("oaddress2"));
		ObjectMapper mapper = new ObjectMapper();
		List<orderItemVO> al = mapper.convertValue(map.get("gaOrderArrayArg"), new TypeReference<List<orderItemVO>>() {});
		
		result = orderService.insertOrders(orderVO, al);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
