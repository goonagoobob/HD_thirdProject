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
	
	@Override
	public List<productDetailVO> orderProductList(String psid) {
		log.info("order product list........");
		return mapper.orderList(psid);
	}
	
	@Override
	public int orderRemove(String oid) {
		int result = 0;
		log.info("order remove..............");
		result = mapper.orderCancel(oid);
		if (result == 0) {
			log.info("service에서 취소가 잘 되지 않았습니다.");
		}
		return result;
	}
	
	@Override
	public orderVO orderRemoveList(String mid, String oid) {
		log.info("order remove list........");
		return mapper.cancelList(mid, oid);
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

	@Transactional
	@Override
	public int insertOrders(orderVO orders, List<orderItemVO> itemList) {
		
		int result = 0;
		mapper.insertOrder(orders);
		result += mapper.orderMileage(orders.getOusedmileage(), orders.getOafterprice(), orders.getMid());
		for (int i = 0; i < itemList.size(); i++) {
			result += mapper.insertOrderItem(itemList.get(i).getPsid(), itemList.get(i).getOicount(), itemList.get(i).getOitotalprice(), orders.getMid());
			System.out.println("order Insert" + itemList.get(i).getPsid());
		}
		System.out.println(result);
		return result;
	}
	
}
