/*********************************
 * @function : 주문 정보를 담는 VO
 * @author : 차민수
 * @Date : Feb 06. 2023.
 *********************************/

package org.goonagoobob.domain.order;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class orderVO {
	
	private String oid; // 주문 id
	private String ozipcode; // 우편번호
	private String oaddress1; // 배송지
	private String oreceiver; // 수령인 이름
	private String ophone; // 수령인 휴대폰 번호
	private String otel; // 수령인 연락처
	private String omemo; // 배송 메세지
	private String oemail; // 수령인 이메일
	private int ousedmileage; // 사용된 마일리지
	private int obeforeprice; // 마일리지 전 가격
	private int oafterprice; // 마일리지 후 가격
	private String ostatus; // 배송 상태
	private String mid; // 회원 id
	private String pmcode; // 결제 방식
	private Date odate; // 주문 날짜
	private String cpid; // 쿠폰 id
	private String oaddress2; // 상세 배송지
	
	private List<orderItemVO> itemList;

}
