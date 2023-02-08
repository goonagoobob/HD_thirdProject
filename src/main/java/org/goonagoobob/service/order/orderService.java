package org.goonagoobob.service.order;

import java.util.List;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderPageDTO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;

public interface orderService {

	public void insert(orderVO orders);
	
	public List<orderVO> getList(Criteria cri, String mid);
	
	public orderPageDTO getListPage(Criteria cri, String mid);
	
	public int orderRemove(String oid);
	
	public orderVO orderRemoveList(String mid, String oid);
	
	public List<productDetailVO> orderProductList(String psid);
}