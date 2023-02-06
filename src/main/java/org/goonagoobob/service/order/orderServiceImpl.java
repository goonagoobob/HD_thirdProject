package org.goonagoobob.service.order;


import java.util.List;

import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderPageDTO;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.mapper.order.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class orderServiceImpl implements orderService {
	
	@Autowired
	private orderMapper mapper;
	
	@Override
	public void insert(orderVO orders) {
		log.info("insert orders.............");
	    mapper.insert(orders);
	}
	
	@Override
	public List<orderVO> getList() {
		log.info("get List.............");
		return mapper.getList();
	}

	@Override
	public List<orderVO> getList(Criteria cri, String mid) {
		log.info("get List with criteria..." + mid + cri);
		return mapper.getListWithPaging(cri, mid);
	}

	@Override
	public orderPageDTO getListPage(Criteria cri, String mid) {
		log.info("getListPage....." + mid + cri);
		return new orderPageDTO(
				mapper.getCountByMid(cri, mid),
				mapper.getListWithPaging(cri, mid));
	}
	
}
