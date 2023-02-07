package org.goonagoobob.service.product;
import org.goonagoobob.domain.product.productCommonVO;
//<!--*********************************
//* @function : 상품 관련 Service Test
//* @author : 조일우
//* @Date : Feb 6. 2023
//* 상품 상세 Service test 추가 Feb 6. 2023
//* 
//********************************* -->
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class productServiceTests {
	
	@Autowired
	private productService service;
	
	@Test
	public void productDetailTests() {
		productCommonVO vo = service.getPDetail("TM2CAKOP661W");
		System.out.println(vo); 
	}
}
