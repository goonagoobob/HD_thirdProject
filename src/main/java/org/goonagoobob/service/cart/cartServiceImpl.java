package org.goonagoobob.service.cart;

import java.security.Principal;
import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.mapper.cart.cartMapper;
import org.goonagoobob.mapper.order.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@AllArgsConstructor

public class cartServiceImpl implements cartService {
	@Autowired
	private cartMapper mapper;
	
	//카트 목록 select 메소드
	@Override
	public List<cartVO> getCartList(String mid){
		log.info("cartList Service,,,,,,");
		List<cartVO> list = mapper.getCartList(mid);
		
		return list;
	}
	
	@Override
	public int deleteCart(String mid) {
		log.info("cartDelete Service.....");
		
		return mapper.deleteCart(mid);
		
	}
}
