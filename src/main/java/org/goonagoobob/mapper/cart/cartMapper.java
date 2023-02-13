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
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.domain.cart.cartsizeVO;

@Mapper
public interface cartMapper {
	//카트 리스트 가져오기
	public List<cartVO> getCartList(String mid);
	//카트 목록 삭제
	public int selectDelete(@Param("mid") String mid, @Param("entryNumber") List<String> entryNumber);
	//장바구니 추가
	public void cartInsert(String mid, String psid, int pquantity);
	//상품별 색상
	public List<cartcolorVO> colorList(String mid, String psid);
	//상품 색상별 사이즈
	public List<cartsizeVO> sizeList(String mid, String psid);
	//옵션 변경
	public void cartUpdate(String mid, String psid, String npsid, int pquantity, int npquantity);
}
