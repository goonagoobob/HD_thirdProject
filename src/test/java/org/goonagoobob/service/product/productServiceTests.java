package org.goonagoobob.service.product;
import java.util.Date;

//<!--*********************************
//* @function : 상품 관련 Service Test
//* @author : 조일우
//* @Date : Feb 6. 2023
//* 상품 상세 Service test 추가 Feb 6. 2023
//* 상품 컬러 변경 Service test 추가 Feb 7. 2023
//* 상품 카테고리 리스트 Service test 추가 Feb 9. 2023
//* 상품 리스트 Service test 추가 Feb 10. 2023
//* 메인 상품 리스트 Service test 추가 Feb 11. 2023
//* 상품 리스트 상품 갯수 Service test 추가 Feb 12. 2023
//* 리뷰 Service testr 추가 Feb 13. 2023
//********************************* -->
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.domain.product.reviewVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class productServiceTests {
	//의존성 주입 
	@Autowired
	private productService service;
	//상품 상세 테스트 
	@Test
	public void productDetailTests() {
		productCommonVO vo = service.getPDetail("TM2CAKOP661W");
		System.out.println(vo); 
	}
	//컬러변 상품 상세 호출 테스트 
	@Test
	public void productColorTests() {
		
		System.out.println(service.getPColor("TM2CAWPC270W_OH")); 
	}
	//카테고리 출력 테스트
	@Test
	public void getCtgrTests() {
		System.out.println(service.getBrd());
		System.out.println(service.getCtgr());
	}
	//상품 리스트 호출 테스트  
	@Test
	public void getListTests() {
		System.out.println(service.getList(null,"여성",null,null,0,9,8));
		System.out.println(service.getList(null,"여성",null,null,0,9,8).size());
	}
	//상품 카테고리별 리스트 출력 테스트 
	@Test
	public void getCtgrListTests() {
		System.out.println(service.getCtgrList("TIME", null, null, null));
	}
	//메인 신상품 베스트 상품 출력 테스트 
	@Test
	public void mainListTest() {
		System.out.println(service.getNewList());
		System.out.println(service.getBestList());
	}
	//상품평 관련 출력 테스트
	@Test
	public void reviewTests() {
		Date today = new Date();
		reviewVO vo = new reviewVO("user1","hi",today,"TM2CAKOP661W_BK",
				"3","123","통통","느슨함",5,1,2,3,1);
		System.out.println(service.getReview("TM2CAKOP661W"));
		service.insertReview(vo);
	}
	//상품 수 호출 테스트
	@Test
	public void countTests() {
		System.out.println(service.getCount("TIME", null, null, null));
		System.out.println(service.newCount());
	}
}
