/*********************************
 * @function : Cart MapperTest 
 * @author : 김주혜
 * @Date : Feb 6. 2023
 * 카트목록 meppertest 추가 Feb 6. 2023
 * 카트삭제 meppertest 추가 Feb 7. 2023
 *********************************/

package org.goonagoobob.mapper.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.domain.cart.cartsizeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class cartMapperTests {
	@Autowired
	private cartMapper mapper;
	// 카트 리스트 가져오기
	@Test
	public void getCartList(){
		String mid = "user1";
		List<cartVO> list = mapper.getCartList(mid);
		log.info(list);
	
	}
	//카트 선택 삭제
	@Test
	public int selectDelete() {
		String mid = "user1";
		List<String> entryNumber = null;
		entryNumber.add("TM2C8WJCS21W_LB_88");
		return mapper.selectDelete(mid, entryNumber);
	}
	
	//카트 추가
	@Test
	public void cartInsert() {
		String mid = "user1";
		String psid = "tkdvndfa";
		int pquantity = 2;
		mapper.cartInsert(mid, psid, pquantity);
	}
	//상품별 색상
	public List<cartcolorVO> colorList() {
		String mid = "user1";
		String psid = "TM2C8WJCS21W_LB_88";
		return mapper.colorList(mid, psid);
	}
	//상품 색상별 사이즈
	public List<cartsizeVO> sizeList() {
		String pcid = "TM2C8WJCS21W_LB";
		return mapper.sizeList(pcid);
	}
	//옵션 변경
	public void cartUpdate() {
		String mid = "user1";
		String psid = "TM2C8WJCS21W_LB_88";
		String npsid = "TM2C8WJCS21W_LB_82";
		int pquantity = 2;
		int npquantity = 1;
	}
	//개별 삭제
	public void eachdelete() {
		String mid = "user1";
		String psid = "TM2C8WJCS21W_LB_88";
	}

	
	
}
