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
