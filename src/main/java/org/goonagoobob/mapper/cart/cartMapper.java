/*********************************
 * @function : Cart Mapper 
 * @author : 김주혜
 * @Date : Feb 6. 2023
 * 카트목록 mapper 추가 Feb 6. 2023
 * 카트삭제 mapper 추가 Feb 7. 2023
 *********************************/

package org.goonagoobob.mapper.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.goonagoobob.domain.cart.cartVO;

@Mapper
public interface cartMapper {
	//카트 리스트 가져오기
	public List<cartVO> getCartList(String mid);
	//카트 목록 삭제
	public int selectDelete(String mid, List<String> entryNumber);
}
