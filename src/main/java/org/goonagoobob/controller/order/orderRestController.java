/*********************************
 * @function : 주문 RestController
 * @author : 차민수
 * @Date : Jan 31. 2023. ~ Feb 13.2023
 * 주문서에서 입력된 주문 정보를 ajax 통신을 통해 JSON 으로 받는 RestController
 *********************************/
package org.goonagoobob.controller.order;

import java.util.List;
import java.util.Map;

import org.goonagoobob.domain.order.orderItemVO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	// 주문서 페이지에서 입력된 주문 정보를 ajax 통신을 통해 JSON 데이터를 VO 에 넣기 위해 직접 맵핑
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
		orderVO.setOafterprice(Integer.parseInt((String)map.get("oafterprice")));
		orderVO.setOemail((String)map.get("oemail"));
		orderVO.setMid((String)map.get("mid"));
		orderVO.setPmcode((String)map.get("pmcode"));
		orderVO.setOaddress2((String)map.get("oaddress2"));
		ObjectMapper mapper = new ObjectMapper();
		List<orderItemVO> al = mapper.convertValue(map.get("gaOrderArrayArg"), new TypeReference<List<orderItemVO>>() {});
		
		for (orderItemVO oi : al) {
			System.out.println(oi);
		}
		
		result = orderService.insertOrders(orderVO, al);
		System.out.println(result);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
