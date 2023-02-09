package org.goonagoobob.domain.order;

import org.goonagoobob.domain.product.productDetailVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class orderItemVO {
	private String psid; // 제품 재고 id
	private String oid; // 주문 번호
	private int oicount; // 각각의 상품 갯수
	private int oitotalprice; // 각각의 상품에 대한 가격	
	private productDetailVO productDetail; // 상품 정보

}
