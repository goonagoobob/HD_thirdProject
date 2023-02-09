//<!--*********************************
// * @function :Service Interface Implements 
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Service Class 추가 Feb 6. 2023
// * 상품 컬러 변경 Service Class 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Service Class 추가 Feb 9. 2023
// ********************************* -->

package org.goonagoobob.service.product;

import java.util.List;

import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.mapper.product.productMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements productService {

	@Autowired
	private productMapper mapper;
	
	@Override
	public String productDetail() {
		return mapper.test();
	}

	@Override
	public productCommonVO getPDetail(String pcid) {
		
		return mapper.getPDetail(pcid);
	}

	@Override
	public productColorVO getPColor(String pcid) {
		
		return mapper.getPColor(pcid);
	}

	@Override
	public List<brandVO> getBrd() {
		return mapper.getBrd();
	}

	@Override
	public List<depth1VO> getCtgr() {
		return mapper.getCtgr();
	}

}
