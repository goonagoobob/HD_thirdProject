/*********************************
 * @function : orderMapper 인터페이스를 테스트
 * @author : 차민수
 * @Date : Feb 06. 2023.
 * 주문 등록, 주문 상품 등록, 주문 조회, 주문할 상품 리스트 조회 추가 Feb 6. 2023
 * 주문 총 개수, 주문 삭제, 주문 삭제를 위해 주문 정보 조회 추가 Feb 7. 2023
 * 페이징한 주문 조회, 주문 취소를 위해 주문 내역 조회 Feb 10. 2023
 * 장바구니를 통해 구매된 상품을 장바구니에서 삭제 Feb 11. 2023
 *********************************/
package org.goonagoobob.mapper.order;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderItemVO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class orderMapperTests {

	@Autowired
	private orderMapper mapper;

	// 로그인한 유저에 따른 총 주문 갯수 테스트
	@Test
	public void testGetCountByMid() {
		Criteria cri = new Criteria();
		log.info(mapper.getCountByMid(cri, "asdf"));
	}

	// 페이징에 따른 주문 내역 조회
	@Test
	public void testGetListWithPaging1() {
		for (orderVO order : mapper.getListWithPaging(new Criteria(), "user1")) {
			System.out.println(order);
		}
	}

	// 주문 내역 등록
	@Test
	public void testInsert() {
		orderVO order = new orderVO();
		order.setOzipcode("18100");
		order.setOaddress1("경상남도 부산시 해운대구 OO아파트");
		order.setOreceiver("장부산");
		order.setOphone("01055555555");
		order.setOtel("");
		order.setOmemo("빨리 왔으면 좋겠어요!");
		order.setOemail("busan@google.com");
		order.setOusedmileage(0);
		order.setObeforeprice(195000);
		order.setOafterprice(order.getObeforeprice() - order.getOusedmileage());
		order.setMid("user1");
		order.setPmcode("001");
		order.setCpid("");
		order.setOaddress2("1110동 1302호");
		mapper.insertOrder(order);
		log.info(order);
	}

	// 주문 취소할 주문 내역 조회
	@Test
	public void orderRemoveList() {
		System.out.println(mapper.cancelList("user1", "3"));
	}

	// 주문할 상품 등록
	@Test
	public void orderItemInsert() {
		orderItemVO itemVO = new orderItemVO();
		itemVO.setPsid("TM2C9ASZ094W_GD_245");
		itemVO.setOid("user1");
		itemVO.setOicount(3);
		itemVO.setOitotalprice(10000);
		mapper.insertOrderItem(itemVO.getPsid(), 0, 0, itemVO.getPsid());
		log.info(itemVO);
	}

	// 장바구니 취소 테스트
	@Test
	public void testDeleteFromCart() {
		cartVO cart = new cartVO();
		cart.setMid("user1");
		cart.setPsid("TM2C9ASZ094W_GD_245");
		int result = mapper.deleteCartByOrder("user1", "TM2C9ASZ094W_GD_245");
		System.out.println(result);
	}

	// 주문 취소 정보 조회 테스트
	@Test
	public void testOrderCancelInfo() {
		// Given
		String oid = "1";

		// When
		orderVO order = mapper.orderCancelInfo(oid);

		// Then
		System.out.println(order);
		// A
	}
	
	// 주문 취소할 상품 조회 테스트
	@Test
	public void testCancelList() {
		String mid = "user1";
		String oid = "1";
		List<orderVO> cancelList = (List<orderVO>) mapper.cancelList(mid, oid);
		System.out.println(cancelList);
	}
	
	// 주문 취소에 따른 마일리지 업데이트 테스트
	@Test
	public void testCancelUpdateMileage() {
		int oafterprice = 10000;
		int usedmileage = 500;
		String mid = "user1";
		int result = mapper.orderCancelMileage(usedmileage, oafterprice, mid);
		System.out.println(result);
	}
	
	// 주문에 따른 마일리지 업데이트 테스트
	@Test
	public void testUpdateMileage() {
		int oafterprice = 10000;
		int usedmileage = 500;
		String mid = "user1";
		int result = mapper.orderMileage(usedmileage, oafterprice, mid);
		System.out.println(result);
	}
	
	// 주문 취소 테스트 => 주문 상태를 결제완료 에서 주문취소 변경
	@Test
	public void orderCancelTest() {
		String oid = "1";
		int result = mapper.orderCancel(oid);
		System.out.println(result);
	}
	
	//
}
