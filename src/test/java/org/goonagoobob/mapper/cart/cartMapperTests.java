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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class cartMapperTests {
	@Autowired
	private cartMapper mapper;
	
	@Test
	public void getCartList(){
		String mid = "user1";
		List<cartVO> list = mapper.getCartList(mid);
		log.info(list);
	
	}
	
	@Test
	public void deleteCart() {
		String mid = "user1";
		int result = mapper.deleteCart(mid);
		log.info(result);
	}
	
	
}
