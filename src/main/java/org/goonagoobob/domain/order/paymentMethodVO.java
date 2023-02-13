/*********************************
 * @function : 결제 수단 정보를 담는 VO
 * @author : 차민수
 * @Date : Feb 06. 2023.
 *********************************/
package org.goonagoobob.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class paymentMethodVO {
	private String pmcode; // 클라이언트 코드
	private String pmcompany; // 결제 대행사 이름
	private int pmmethod; // 결제 방법
}
