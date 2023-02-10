//<!--*********************************
// * @function : Mapper Interface
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Mapper 추가 Feb 6. 2023
// * 상품 컬러변경 Mapper 추가 Feb 7. 2023
// * 상품 카테고리 리스트 Mapper 추가 Feb 9. 2023
// * 상품 리스트 Mapper 추가 Feb 10. 2023
// ********************************* -->

package org.goonagoobob.mapper.product;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;

@Mapper
public interface productMapper {
	public String test();

	public productCommonVO getPDetail(@Param("pid") String pid);

	public productColorVO getPColor(@Param("pcid") String pcid);

	public List<brandVO> getBrd();

	public List<depth1VO> getCtgr();

	public List<productCommonVO> getList(@Param("brand")String brand, @Param("depth1")String depth1, 
			@Param("depth2")String depth2, @Param("depth3") String depth3, @Param("orderBy")String orderBy, 
			 @Param("Piter")int Piter, @Param("productNum")int productNum);

	public List<String> getCtgrList(@Param("brand")String brand, @Param("depth1")String depth1, 
			@Param("depth2")String depth2, @Param("depth3") String depth3);
}
