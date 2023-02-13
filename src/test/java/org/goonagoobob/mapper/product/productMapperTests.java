//<!--*********************************
// * @function : Mapper Test
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Mapper Test 추가 Feb 6. 2023
// * 상품 컬러변경 Mapper Test 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Mapper Test 추가 Feb 9. 2023
// * 상품 리스트 Mapper Test 추가 Feb 10. 2023
// * 메인 상품 리스트 Mapper Test 추가 Feb 11. 2023
// * 상품 리스트 상품 갯수 Mapper Test 추가 Feb 12. 2023
// * 리뷰 Mapper Test 추가 Feb 13. 2023
// ********************************* -->

package org.goonagoobob.mapper.product;
import java.util.Date;

import org.goonagoobob.domain.product.reviewVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class productMapperTests {
	//mapper 의존성 주입 
	@Autowired
	private productMapper mapper;
	//리뷰VO 작성		
	Date today = new Date();
	reviewVO vo = new reviewVO("user1","hi",today,"TM2CAKOP661W_BK",
			"3","123","통통","느슨함",5,1,2,3,1);

	//상품 상세 테스트 
	@Test
	public void productDetailTests() {
		System.out.println(mapper.getPDetail("TM2CAKOP661W"));
		
	}
	//특정 색상 상품 정보 출력  테스트 
	@Test
	public void productColorChgTests() {
		System.out.println(mapper.getPColor("TM2CAKOP661W"));
	}
	//상품 브랜드 카테고리 출력  테스트 
	@Test
	public void getCategoryTests() {
		System.out.println(mapper.getBrd());
		System.out.println(mapper.getCtgr());
	}
	//상품 리스트 출력 테스트 
	@Test
	public void getListTests() {
		System.out.println(mapper.getList(null, "여성", null, null, "order by pcprice", 9, 17));
		System.out.println(mapper.getList(null, "여성", null, null, "order by pcprice", 9, 17).size());
	
	}
	//상품 카테고리별 리스트 출력 테스트 
	@Test
	public void getCtgrListTests() {
		System.out.println(mapper.getCtgrList("TIME", null, null, null));
	}
	//메인 신상품 베스트 상품 출력 테스트 
	@Test
	public void mainListTest() {
		System.out.println(mapper.getNewList());
		System.out.println(mapper.getBestList());
	}
	//상품평 관련 출력 테스트
	@Test
	public void reviewTests() {
		System.out.println(mapper.getReview("TM2CAKOP661W"));
		mapper.insertReview(vo);
	}
	//상품 수 호출 테스트
	@Test
	public void countTests() {
		System.out.println(mapper.getCount("TIME", null, null, null));
		System.out.println(mapper.newCount());
	}
}
