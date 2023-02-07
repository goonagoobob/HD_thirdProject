package org.goonagoobob.service.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.mapper.cart.cartMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor

public class cartServiceImpl {
	
	private cartMapper mapper;
	
	//카트 목록 select 메소드
	public List<cartVO> getCartList(String mid){
		log.info("cartList,,,,,,");
		List<cartVO> list = mapper.getCartList(mid);
		
		return list;
	}
}
