package org.goonagoobob.service.product;
//<!--*********************************
//* @function : 상품 관련 Service Test
//* @author : 조일우
//* @Date : Feb 6. 2023
//* 상품 상세 Service test 추가 Feb 6. 2023
//* 상품 컬러 변경 Service test 추가 Feb 7. 2023
//* 상품 카테고리 리스트 Service test 추가 Feb 9. 2023
//********************************* -->
import org.goonagoobob.domain.product.productCommonVO;

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
	
	@Test
	public void productColorTests() {
		
		System.out.println(service.getPColor("TM2CAWPC270W_OH")); 
	}
	@Test
	public void getCtgrTests() {
		System.out.println(service.getBrd());
		System.out.println(service.getCtgr());
	}
	@Test
	public void getListTests() {
		System.out.println(service.getList(null,"여성",null,null,0,9,8));
		System.out.println(service.getList(null,"여성",null,null,0,9,8).size());
	}
}
