package org.goonagoobob.mapper.order;


import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class orderMapperTests {

	@Autowired
	private orderMapper mapper;
	
//	@Test
//	public void testGetCountByMid() {
//		Criteria cri = new Criteria();
//		log.info(mapper.getCountByMid(cri, "asdf"));
//	}
	
//	@Test
//	public void testGetListWithPaging1() {		
//		for (orderVO order : mapper.getListWithPaging(new Criteria(), "user1")) {
//			System.out.println(order);
//		}
//	}
	
//	@Test
//	public void testInsert() {
//		orderVO order = new orderVO();
//		order.setOzipcode("18100");
//		order.setOaddress1("경상남도 부산시 해운대구 OO아파트");
//		order.setOreceiver("장부산");
//		order.setOphone("01055555555");
//		order.setOtel("");
//		order.setOmemo("빨리 왔으면 좋겠어요!");
//		order.setOemail("busan@google.com");
//		order.setOusedmileage(0);
//		order.setObeforeprice(195000);
//		order.setOafterprice(order.getObeforeprice() - order.getOusedmileage());
//		order.setMid("user1");
//		order.setPmcode("001");
//		order.setCpid("");
//		order.setOaddress2("1110동 1302호");
//		mapper.insert(order);
//		log.info(order);
//	}
	
	@Test
	public void orderRemoveList() {
		System.out.println(mapper.cancelList("user1", "3"));
	}
	
	
}
