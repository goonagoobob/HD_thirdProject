/*********************************
 * @function : Cart Service 
 * @author : 김주혜
 * @Date : Feb 6. 2023
 * 카트목록 service 추가 Feb 6. 2023
 * 카트삭제 service 추가 Feb 7. 2023
 *********************************/

package org.goonagoobob.service.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.cart.cartcolorVO;

public interface cartService {
	//카트 리스트
	public List<cartVO> getCartList(String mid);
	
	//선택 상품 삭제
	public void selectDelete(String mid, List<String> entryNumber);
	
	//장바구니 추가
	public void cartInsert(String mid, String psid, int pquantity);
	
	//색상 select
	public List<cartcolorVO> colorList(String mid);
	//총금액
	//public List<cartVO> selectprice(String mid, List<String> entryNumber);
}
