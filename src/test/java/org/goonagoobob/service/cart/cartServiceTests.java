/*********************************
 * @function : Cart servicetest 
 * @author : 김주혜
 * @Date : Feb 6. 2023
 * 카트목록 servicetest 추가 Feb 6. 2023
 * 카트삭제 servicetest 추가 Feb 7. 2023
 *********************************/

package org.goonagoobob.service.cart;

import java.util.List;

import org.goonagoobob.domain.cart.cartVO;
import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.domain.cart.cartsizeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class cartServiceTests {
	@Autowired
	private cartService service;
	//카트 목록 select 메소드
	@Test
	public void getCartList() {
		String mid = "user1";
		List<cartVO> list = service.getCartList(mid);
		log.info(list);
	}
	//카트 선택 삭제
	@Test
	public void selectDelete() {
		String mid = "user1";
		List<String> entryNumber = null;
		entryNumber.add("TM2C8WJCS21W_LB_88");
	}
	//카트 상품별 색상
	@Test
	public List<cartcolorVO> colorList() {
		String mid = "user1";
		String psid = "TM2C8WJCS21W_LB_88";
		return service.colorList(mid, psid);
	}
	//카트 담기
	@Test
	public void cartInsert() {
		String mid = "user1";
		String psid = "tkdvsgna";
		int pquantity = 2;
		service.cartInsert(mid, psid, pquantity);
	}
	//카트 상품 색상별 사이즈
	@Test
	public List<cartsizeVO> sizeList() {
		String pcid = "TM2C8WJCS21W_LB";
		return service.sizeList(pcid);
	}
	//카트 옵션 변경
	@Test
	public void cartUpdate() {
		String mid = "user1";
		String psid = "TM2C8WJCS21W_LB_88";
		String npsid = "TM2C8WJCS21W_LB_86";
		int pquantity = 2;
		int npquantity = 1;
	}
	//개별 삭제
	@Test
	public void eachdelete() {
		String mid = "user1";
		String psid = "TM2C8WJCS21W_LB_88";
	}

}
