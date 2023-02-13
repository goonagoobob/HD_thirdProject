//<!--*********************************
// * @function :Service Interface Implements 
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Service Class 추가 Feb 6. 2023
// * 상품 컬러 변경 Service Class 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Service Class 추가 Feb 9. 2023
// * 상품 리스트 Service Class 추가 Feb 10. 2023
// * 메인 상품 리스트 Service Class 추가 Feb 11. 2023
// * 상품 리스트 상품 갯수 Service Class 추가 Feb 12. 2023
// * 리뷰 삽입 Service Class 추가 Feb 13. 2023
// ********************************* -->

package org.goonagoobob.service.product;

import java.util.List;

import org.goonagoobob.domain.product.FileDto;
import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.domain.product.reviewVO;
import org.goonagoobob.mapper.product.productMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements productService {
	//맵퍼 의존성 주입
	@Autowired
	private productMapper mapper;
	//상품 상세 호출  
	@Override
	public productCommonVO getPDetail(String pcid) {
		
		return mapper.getPDetail(pcid);
	}
	//특정 색깔 상품 호출 
	@Override
	public productColorVO getPColor(String pcid) {
		
		return mapper.getPColor(pcid);
	}
	//브랜드 전체 호출 
	@Override
	public List<brandVO> getBrd() {
		return mapper.getBrd();
	}
	//카테고리 전체 호출 
	@Override
	public List<depth1VO> getCtgr() {
		return mapper.getCtgr();
	}
	//특정 조건 상품 리스트 호출 
	@Override
	public List<productCommonVO> getList(String brand, String depth1, String depth2, String depth3, int orderBy, int Piter, int productNum) {
		String orderByString ="";
		if(orderBy == 1) {
			orderByString = "order by pcprice";
		}else if(orderBy == 2) {
			orderByString = "order by pcprice desc";
		}else if (orderBy == 3) {
			orderByString = "order by preleasedate";
		}
		productNum += Piter;
		return mapper.getList(brand, depth1, depth2, depth3, orderByString, Piter, productNum);
	}
	//특정 조건 상품 카테고리 리스트 호출 
	@Override
	public List<String> getCtgrList(String brand, String depth1, String depth2, String depth3) {

		return mapper.getCtgrList(brand,depth1,depth2,depth3);
	}
	//신상품 호출 
	@Override
	public List<productCommonVO> getNewList() {
		return mapper.getNewList();
	}
	//베스트 상품 호출 
	@Override
	public List<productCommonVO> getBestList() {
		return mapper.getBestList();
	}
	//신상품 갯수 호출 
	@Override
	public int newCount() {
		return mapper.newCount();
	}
	//특정 조건 상품 갯수 호출 
	@Override
	public int getCount(String brand, String depth1, String depth2, String depth3) {
		return mapper.getCount(brand,depth1,depth2,depth3);
	}
	//상품 리뷰 호출 
	@Override
	public List<reviewVO> getReview(String pid) {
		return mapper.getReview(pid);
	}
	//내가쓴 리뷰 호출 
	@Override
	public String getMyReview(String pid, String username) {
		return mapper.getMyReview( pid, username);
	}
	//리뷰 삽입 
	@Override
	public void insertReview(reviewVO vo) {
		mapper.insertReview(vo);
	}

}
