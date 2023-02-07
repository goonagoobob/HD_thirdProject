//<!--*********************************
// * @function : Mapper Interface
// * @author : 조일우
// * @Date : Feb 6. 2023
// * 상품 상세 Mapper 추가 Feb 6. 2023
// * 
// ********************************* -->

package org.goonagoobob.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.product.productCommonVO;

@Mapper
public interface productMapper {
	public String test();

	public productCommonVO getPDetail(@Param("pid") String pcid);
}
