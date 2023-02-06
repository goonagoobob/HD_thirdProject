package org.goonagoobob.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderVO;

@Mapper
public interface orderMapper {

	public void insert(orderVO orders); // 주문 등록
	
	public int getCountByMid(@Param("cri") Criteria cri, @Param("mid") String mid); // 총 주문 갯수
	
	public List<orderVO> getList(); // 주문 조회
	
	public List<orderVO> getListWithPaging(@Param("cri") Criteria cri, @Param("mid") String mid); // 페이징한 주문 조회
	
}