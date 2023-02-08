package org.goonagoobob.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;

@Mapper
public interface orderMapper {

	public void insert(orderVO orders); // 주문 등록
	
	public int getCountByMid(@Param("cri") Criteria cri, @Param("mid") String mid); // 총 주문 갯수
	
	public List<orderVO> getListWithPaging(@Param("cri") Criteria cri, @Param("mid") String mid); // 페이징한 주문 조회
	
	public int orderCancel(@Param("oid") String oid); // 주문 상태를 주문 취소로 변경 => 주문 삭제임
	
	public orderVO cancelList(@Param("mid") String mid, @Param("oid") String oid); // 주문 취소할 주문 상품 리스트를 조회
	
	public List<productDetailVO> orderList(@Param("psid") String psid); //주문할 상품 리스트 조회
	
}