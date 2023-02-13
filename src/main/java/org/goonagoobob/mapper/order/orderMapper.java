/*********************************
 * @function : orderMapper.xml 사용하기 위한 Mapper 인터페이스
 * @author : 차민수
 * @Date : Feb 06. 2023.
 * 주문 등록, 주문 상품 등록, 주문 조회, 주문할 상품 리스트 조회 추가 Feb 6. 2023
 * 주문 총 개수, 주문 삭제, 주문 삭제를 위해 주문 정보 조회 추가 Feb 7. 2023
 * 페이징한 주문 조회, 주문 취소를 위해 주문 내역 조회 Feb 10. 2023
 * 장바구니를 통해 구매된 상품을 장바구니에서 삭제 Feb 11. 2023
 *********************************/
package org.goonagoobob.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.domain.order.orderVO;
import org.goonagoobob.domain.product.productDetailVO;

@Mapper
public interface orderMapper {

	public int insertOrder(orderVO orders); // 주문 등록
	
	public int insertOrderItem(@Param("psid") String psid, @Param("oicount") int oicount, @Param("oitotalprice") int oitotalprice, @Param("mid") String mid); //주문 상품 등록
	
	public int getCountByMid(@Param("cri") Criteria cri, @Param("mid") String mid); // 총 주문 갯수
	
	public List<orderVO> getListWithPaging(@Param("cri") Criteria cri, @Param("mid") String mid); // 페이징한 주문 조회
	
	public int orderCancel(@Param("oid") String oid); // 주문 상태를 주문 취소로 변경 => 주문 삭제임
	
	public int orderCancelMileage(@Param("usedmileage") int usedmileage, @Param("oafterprice") int oafterprice, @Param("mid") String mid);
	
	public orderVO cancelList(@Param("mid") String mid, @Param("oid") String oid); // 주문 취소할 주문 상품 리스트를 조회
	
	public productDetailVO orderList(@Param("psid") String psid); //주문할 상품 리스트 조회
	
	public int orderMileage(@Param("usedmileage") int usedmileage, @Param("oafterprice") int oafterprice, @Param("mid") String mid); // 주문 취소에 따른 사용된 마일리지 환불
	
	public orderVO orderCancelInfo(@Param("oid") String oid); //주문 취소를 위해 주문 내역 조회
	
	public int deleteCartByOrder(@Param("mid") String mid, @Param("psid") String psid); // 장바구니를 통해 구매된 상품을 장바구니에서 삭제
}