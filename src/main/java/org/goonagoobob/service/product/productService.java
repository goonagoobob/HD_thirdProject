//<!--*********************************
// * @function :Service Interface
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Service Interface 추가 Feb 6. 2023
// * 상품 컬러 변경 Service Interface 추가 Feb 7. 2023
// ********************************* -->

package org.goonagoobob.service.product;

import java.util.List;

import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.springframework.stereotype.Service;

@Service
public interface productService {
	//상품 상세에 필요한 상품VO를 추출 
	public String productDetail();

	public productCommonVO getPDetail(String pcid);

	public productColorVO getPColor(String pcid);
}
