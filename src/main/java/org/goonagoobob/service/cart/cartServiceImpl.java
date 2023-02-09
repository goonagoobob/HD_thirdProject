/*********************************
 * @function : Cart ServiceImpl 
 * @author : 김주혜
 * @Date : Feb 6. 2023
 * 카트목록 ServiceImpl 추가 Feb 6. 2023
 * 카트삭제 ServiceImpl 추가 Feb 7. 2023
 *********************************/

package org.goonagoobob.service.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.mapper.cart.cartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
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
	public void selectDelete(String mid, List<String> entryNumber) {
		log.info("cartDelete Service.....");
		
		mapper.selectDelete(mid, entryNumber);
		
	}
	
	@Override
	public void cartInsert(String mid, String psid, int pquantity) {
		log.info("cartInsert service....");
		
		mapper.cartInsert(mid, psid, pquantity);
	}
}
