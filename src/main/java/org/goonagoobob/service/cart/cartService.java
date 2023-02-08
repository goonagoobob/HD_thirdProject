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

public interface cartService {
	//카트 리스트
	public List<cartVO> getCartList(String mid);
	
	//전체 상품 삭제
	public int selectDelete(String mid, List<String> entryNumber);
}
