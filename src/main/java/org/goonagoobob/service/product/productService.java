//<!--*********************************
// * @function :Service Interface
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Service Interface 추가 Feb 6. 2023
// * 상품 컬러 변경 Service Interface 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Service Interface 추가 Feb 9. 2023
// * 상품 리스트 Service Interface 추가 Feb 10. 2023
// ********************************* -->

package org.goonagoobob.service.product;

import java.util.List;

import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.springframework.stereotype.Service;

@Service
public interface productService {
	//상품 상세에 필요한 상품VO를 추출 
	public String productDetail();

	public productCommonVO getPDetail(String pcid);

	public productColorVO getPColor(String pcid);

	public List<brandVO> getBrd();

	public List<depth1VO> getCtgr();

	public List<productCommonVO> getList(String brand, String depth1, String depth2, String depth3, int orderBy, int Piter, int productNum);

	public List<String> getCtgrList(String brand, String depth1, String depth2, String depth3);

	public List<productCommonVO> getNewList();

	public List<productCommonVO> getBestList();

	public int newCount();

	public int getCount(String brand, String depth1, String depth2, String depth3);
}
