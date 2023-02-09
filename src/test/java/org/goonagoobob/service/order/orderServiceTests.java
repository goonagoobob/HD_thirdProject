package org.goonagoobob.service.order;


import java.util.Date;

import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.service.order.orderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class orderServiceTests {

	@Autowired
	private orderServiceImpl orderService;
	
	@Test
	public void insertTest() {
		log.info("insertTest.....");
        orderVO orders = new orderVO();
        orders.setOid("oididid");
        orders.setOzipcode("code");
        orders.setOaddress1("oaddress1");
        orders.setOreceiver("oreceiver");
        orders.setOphone("ophone");
        orders.setOtel("otel");
        orders.setOmemo("omemo");
        orders.setOemail("ozip");
        orders.setOusedmileage(2000);
        orders.setObeforeprice(20000);
        orders.setOafterprice(18000);
        orders.setOstatus("주문완료");
        orders.setMid("ehfhfh1313@naver.com");
        orders.setPmcode("001");
        orders.setOdate( new Date());
        orders.setCpid("cpid");
        orders.setOaddress2("address2");
        
        //orderService.insert(orders);
	}
}
