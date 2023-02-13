/*********************************
 * @function : orderService를 테스트
 * @author : 차민수
 * @Date : Feb 10. 2023.
 * 주문 등록 서비스 Feb 9. 2023
 * 주문 총 개수, 주문 삭제, 주문 삭제를 위해 주문 정보 조회 추가 Feb 7. 2023
 * 페이징한 주문 조회, 주문 취소를 위해 주문 내역 조회 Feb 10. 2023
 * 장바구니를 통해 구매된 상품을 장바구니에서 삭제 Feb 11. 2023
 *********************************/
package org.goonagoobob.service.order;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderItemVO;
import org.goonagoobob.domain.order.orderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class orderServiceTests {

	@Autowired
	private orderServiceImpl orderService;
	
	// 주문하기 service 단 테스트 
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
        List<orderItemVO> itemList = new ArrayList<>();
        int result = 0;
        result = orderService.insertOrders(orders, itemList);
        System.out.println(result);
	}
	
	// 상품 정보 조회 service 단 테스트
	@Test
	public void readProduct() {
		String psid = "TM2C9ASZ094W_GD_245";
		System.out.println(orderService.orderProduct(psid));
	}
	
	// 주문 삭제하는 비즈니스 로직 service 단 테스트
	@Test
	public void removeOrder() {
		String oid = "1";
		int result = 0;
		result = orderService.orderRemove(oid);
		System.out.println(result);
	}
	// 주문 취소 전 주문 취소한 상품 리스트를 조회하는 service 메서드 구현 테스트
	@Test
	public void orderRemovList() {
		String mid = "user1";
		String oid = "1";
		System.out.println(orderService.orderRemoveList(mid, oid));
	}
	// 주문 내역을 조회하는 service 메서드 구현 테스트
	@Test
	public void getList() {
		Criteria cri = new Criteria();
		String mid = "user1";
		System.out.println(orderService.getListPage(cri, mid));
	}
	
}
