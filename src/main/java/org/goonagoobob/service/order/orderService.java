package org.goonagoobob.service.order;

import java.util.List;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderItemVO;
import org.goonagoobob.domain.order.orderPageDTO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;

public interface orderService {

	public int insertOrders(orderVO orders, List<orderItemVO> itemList); // 주문 등록 => 주문 테이블 oid 등록과 주문 아이템 테이블 상품들 트랜잭션 처리하기
		
	public List<orderVO> getList(Criteria cri, String mid); 
	
	public orderPageDTO getListPage(Criteria cri, String mid);
	
	public int orderRemove(String oid);
	
	public orderVO orderRemoveList(String mid, String oid);
	
	public List<productDetailVO> orderProductList(String psid);
	
}