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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class cartServiceTests {
	@Autowired
	private cartService service;
	
	@Test
	public void getCartList() {
		String mid = "user1";
		List<cartVO> list = service.getCartList(mid);
		log.info(list);
	}
	
	@Test
	public void deleteCart() {
		String mid = "user1";
		int result = service.deleteCart(mid);
		log.info(result);
	}
}
