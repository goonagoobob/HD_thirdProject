/*********************************
 * @function : 비즈니스 로직을 처리하기 위해 orderService 추가
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

public interface orderService {

	public int insertOrders(orderVO orders, List<orderItemVO> itemList); // 주문 등록 => 주문 테이블 oid 등록과 주문 아이템 테이블 상품들 트랜잭션 처리하기
		
	public List<orderVO> getList(Criteria cri, String mid); // 주문 내역에 주문 정보를 조회하는 service
	
	public orderPageDTO getListPage(Criteria cri, String mid); // 주문 내역에 주문 정보를 페이징 처리하여 조회하는 service
	
	public int orderRemove(String oid); // 주문을 취소하는 service => 주문을 취소하면 사용된 마일리지를 반환하는 로직 트랜잭션 처리
	
	public orderVO orderRemoveList(String mid, String oid); // 주문 취소할 상품들의 정보를 조회하는 service
	
	public productDetailVO orderProduct(String psid); // psid 에 따른 주문 상품 정보 조회 service
	
}