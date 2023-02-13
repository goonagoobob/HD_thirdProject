/*********************************
 * @function : 비즈니스 로직을 처리하기 위해 orderService 를 구현한 orderServiceImpl 추가
 * @author : 차민수
 * @Date : Feb 08. 2023.
 *********************************/
package org.goonagoobob.service.order;


import java.util.List;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderItemVO;
import org.goonagoobob.domain.order.orderPageDTO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;
import org.goonagoobob.mapper.order.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class orderServiceImpl implements orderService {
	
	@Autowired
	private orderMapper mapper;
	
	// psid 에 따른 주문 상품 정보 조회 service 메서드 구현
	@Override
	public productDetailVO orderProduct(String psid) {
		log.info("order product list........");
		return mapper.orderList(psid);
	}
	
	// 주문 삭제하는 비즈니스 로직 => 주문에 대한 정보를 불러온 후, 주문 상태를 '주문 취소' 로 변경 후, 주문에 사용된 마일리지 반환
	@Transactional
	@Override
	public int orderRemove(String oid) {
		int result = 0;
		log.info("order remove..............");
		orderVO order = mapper.orderCancelInfo(oid);
		result += mapper.orderCancel(oid);
		result += mapper.orderCancelMileage(order.getOusedmileage(), order.getOafterprice(), order.getMid());
		if (result == 0) {
			log.info("service에서 취소가 잘 되지 않았습니다.");
		}
		System.out.println(result);
		return result;
	}
	
	// 주문 취소 전 주문 취소한 상품 리스트를 조회하는 service 메서드 구현
	@Override
	public orderVO orderRemoveList(String mid, String oid) {
		log.info("order remove list........");
		return mapper.cancelList(mid, oid);
	}
	
	// 주문 내역을 조회하는 service 메서드 구현
	@Override
	public List<orderVO> getList(Criteria cri, String mid) {
		log.info("get List with criteria..." + mid + cri);
		return mapper.getListWithPaging(cri, mid);
	}

	// 주문 내역을 페이징 처리하여 조회하는 service 메서드 구현
	@Override
	public orderPageDTO getListPage(Criteria cri, String mid) {
		log.info("getListPage....." + mid + cri);
		return new orderPageDTO(
				mapper.getCountByMid(cri, mid),
				mapper.getListWithPaging(cri, mid));
	}

	// 주문 하기를 수행하는 비즈니스 로직 => 주문 정보를 토대로 주문 데이터를 등록하고, 주문에 사용된 유저의 마일리지를 업데이트 후,
	// 										주문에 따른 상품 정보를 등록한다. 마지막으로 장바구니를 통해서 주문을 넣은 경우, 장바구니에 주문된 상품을 제거한다.
	@Transactional
	@Override
	public int insertOrders(orderVO orders, List<orderItemVO> itemList) {
		
		int result = 0;
		mapper.insertOrder(orders);
		result += mapper.orderMileage(orders.getOusedmileage(), orders.getOafterprice(), orders.getMid());
		for (int i = 0; i < itemList.size(); i++) {
			result += mapper.insertOrderItem(itemList.get(i).getPsid(), itemList.get(i).getOicount(), itemList.get(i).getOitotalprice(), orders.getMid());
			System.out.println("order Insert" + itemList.get(i).getPsid());
			result += mapper.deleteCartByOrder(orders.getMid(), itemList.get(i).getPsid());
			System.out.println("cart Delete : " + itemList.get(i).getPsid());
		}
		System.out.println(result);
		return result;
	}
	
}
