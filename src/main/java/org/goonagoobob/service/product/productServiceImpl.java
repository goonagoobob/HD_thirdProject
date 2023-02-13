//<!--*********************************
// * @function :Service Interface Implements 
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Service Class 추가 Feb 6. 2023
// * 상품 컬러 변경 Service Class 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Service Class 추가 Feb 9. 2023
// * 상품 리스트 Service Class 추가 Feb 10. 2023
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

	@Override
	public List<String> getCtgrList(String brand, String depth1, String depth2, String depth3) {

		return mapper.getCtgrList(brand,depth1,depth2,depth3);
	}

	@Override
	public List<productCommonVO> getNewList() {
		return mapper.getNewList();
	}

	@Override
	public List<productCommonVO> getBestList() {
		return mapper.getBestList();
	}

	@Override
	public int newCount() {
		return mapper.newCount();
	}

	@Override
	public int getCount(String brand, String depth1, String depth2, String depth3) {
		return mapper.getCount(brand,depth1,depth2,depth3);
	}

}
