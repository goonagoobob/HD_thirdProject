/* *********************************
 * @function : CartServiceImpl
 * @author : 김주혜
 * 장바구니 목록 조회 구현
 * 장바구니 넣기 구현
 * 선택 상품 삭제 구현
 * 상품 색상 select 구현
 * 상품 사이즈 select 구현
 * 선택 상품 변경 구현
 * 개별 상품 삭제 구현
 **********************************/

package org.goonagoobob.service.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.domain.cart.cartsizeVO;
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
	//카트 선택 삭제
	@Override
	public void selectDelete(String mid, List<String> entryNumber) {
		log.info("cartDelete Service.....");
		
		mapper.selectDelete(mid, entryNumber);
	}
	//카트 상품별 색상
	@Override
	public List<cartcolorVO> colorList(String mid, String psid) {
		log.info("colorList Service....");
		
		List<cartcolorVO> cList = mapper.colorList(mid, psid);
		return cList;
	}
	//카트 담기
	@Override
	public void cartInsert(String mid, String psid, int pquantity) {
		log.info("cartInsert service....");
		
		mapper.cartInsert(mid, psid, pquantity);
	}
	//카트 상품 색상별 사이즈
	@Override
	public List<cartsizeVO> sizeList(String pcid){
		log.info("sizeList Service...");
		
		List<cartsizeVO> sList = mapper.sizeList(pcid);
		return sList;
	}
	//카트 옵션 변경
	@Override
	public void cartUpdate(String mid, String psid, String npsid, int pquantity, int npquantity) {
		log.info("cartUpdate Service...");
		
		mapper.cartUpdate(mid, psid, npsid, pquantity, npquantity);
	}
	//개별 삭제
	@Override
	public void eachdelete(String mid, String psid) {
		log.info("eachdelete Service...");
		
		mapper.eachdelete(mid, psid);
	}
}
