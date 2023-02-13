//<!--*********************************
// * @function :Service Interface
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Service Interface 추가 Feb 6. 2023
// * 상품 컬러 변경 Service Interface 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Service Interface 추가 Feb 9. 2023
// * 상품 리스트 Service Interface 추가 Feb 10. 2023
// * 메인 상품 리스트 Service Interface 추가 Feb 11. 2023
// * 상품 리스트 상품 갯수 Service Interface 추가 Feb 12. 2023
// * 리뷰 삽입 Service Interface 추가 Feb 13. 2023
// ********************************* -->

package org.goonagoobob.service.product;

import java.util.List;

import org.goonagoobob.domain.product.FileDto;
import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.domain.product.reviewVO;
import org.springframework.stereotype.Service;

@Service
public interface productService {
 	//특정 상품 상세 호출 
	public productCommonVO getPDetail(String pcid);
	//특정 색깔 상품 호출 
	public productColorVO getPColor(String pcid);
	//모든 브랜드 호출 
	public List<brandVO> getBrd();
	//모든 카테고리 호출 
	public List<depth1VO> getCtgr();
	//특정 상품 리스트 호출 
	public List<productCommonVO> getList(String brand, String depth1, String depth2, String depth3, int orderBy, int Piter, int productNum);
	//특정 깊이 카테고리 호출 
	public List<String> getCtgrList(String brand, String depth1, String depth2, String depth3);
	//신상품 리스트 호출 
	public List<productCommonVO> getNewList();
	//베스트 상품 리스트 호출 
	public List<productCommonVO> getBestList();
	//신상품 갯수 호출 
	public int newCount();
	//특정 조건 상품 갯수 호출 
	public int getCount(String brand, String depth1, String depth2, String depth3);
	//특정 상품 리뷰 호출 
	public List<reviewVO> getReview(String pid);
	//내가 작성한 리뷰 호출 
	public String getMyReview(String pid, String username);
	//상품 리뷰 삽입 
	public void insertReview(reviewVO vo);
}
