package org.goonagoobob.service.order;

import java.util.List;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderPageDTO;
import org.goonagoobob.domain.order.orderVO;

public interface orderService {

	public void insert(orderVO orders);
	
	public List<orderVO> getList();
	
	public List<orderVO> getList(Criteria cri, String mid);
	
	public orderPageDTO getListPage(Criteria cri, String mid);
}