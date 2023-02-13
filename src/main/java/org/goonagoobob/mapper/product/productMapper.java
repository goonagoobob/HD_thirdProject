//<!--*********************************
// * @function : Mapper Interface
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Mapper 추가 Feb 6. 2023
// * 상품 컬러변경 Mapper 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Mapper 추가 Feb 9. 2023
// * 상품 리스트 Mapper 추가 Feb 10. 2023
// * 메인 상품 리스트 Mapper 추가 Feb 11. 2023
// * 상품 리스트 상품 갯수 Mapper 추가 Feb 12. 2023
// * 리뷰 Mapper 추가 Feb 13. 2023
// ********************************* -->

package org.goonagoobob.mapper.product;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.product.FileDto;
import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.domain.product.reviewVO;
import org.springframework.security.access.method.P;

@Mapper
public interface productMapper {
	//특정 상품 상세 정보 호출 
	public productCommonVO getPDetail(@Param("pid") String pid);
	//특정 상품 특정 색상 정보 호출 
	public productColorVO getPColor(@Param("pcid") String pcid);
	//모든 브랜드 호출 
	public List<brandVO> getBrd();
	//모든 카테고리 호출 
	public List<depth1VO> getCtgr();
	//특정 조건 모든 상품호출 
	public List<productCommonVO> getList(@Param("brand")String brand, @Param("depth1")String depth1, 
			@Param("depth2")String depth2, @Param("depth3") String depth3, @Param("orderBy")String orderBy, 
			 @Param("Piter")int Piter, @Param("productNum")int productNum);
	//상품이 존재하는 카테고리 호출 
	public List<String> getCtgrList(@Param("brand")String brand, @Param("depth1")String depth1, 
			@Param("depth2")String depth2, @Param("depth3") String depth3);
	//신상품 호출 
	public List<productCommonVO> getNewList();
	//가장 많이 팔린 상품 호출 
	public List<productCommonVO> getBestList();
	//신상품 수 호출 
	public int newCount();
	//특정 조건 상품 수 호출 
	public int getCount(String brand, String depth1, String depth2, String depth3);
	//특정 상품 상품평 호출 
	public List<reviewVO> getReview(@Param("pid") String pid);
	//내 상품평 호출 
	public String getMyReview(@Param("pid") String pid,@Param("mid")  String username);
	//리뷰 저장 
	public void insertReview(reviewVO vo);
	//파일 정보 저장 
	public void insertFileDto(FileDto dto,@Param("RNO") int RNO);
}
