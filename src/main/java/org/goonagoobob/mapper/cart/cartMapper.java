/* *********************************
 * @function : CartMapper
 * @author : 김주혜
 * 장바구니 목록 조회 구현
 * 장바구니 넣기 구현
 * 선택 상품 삭제 구현
 * 상품 색상 select 구현
 * 상품 사이즈 select 구현
 * 선택 상품 변경 구현
 * 개별 상품 삭제 구현
 **********************************/

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
	//카트 선택 삭제
	public int selectDelete(@Param("mid") String mid, @Param("entryNumber") List<String> entryNumber);
	//카트 추가
	public void cartInsert(String mid, String psid, int pquantity);
	//상품별 색상
	public List<cartcolorVO> colorList(String mid, String psid);
	//상품 색상별 사이즈
	public List<cartsizeVO> sizeList(String pcid);
	//옵션 변경
	public void cartUpdate(String mid, String psid, String npsid, int pquantity, int npquantity);
	//개별 삭제
	public void eachdelete(String mid, String psid);
}
