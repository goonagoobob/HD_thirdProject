package org.goonagoobob.service.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;

public interface cartService {
	//카트 리스트
	public List<cartVO> getCartList(String mid);
}
