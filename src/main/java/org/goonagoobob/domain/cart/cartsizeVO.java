/* *********************************
 * @function : CartSizeVO
 * @author : 김주혜
 * 상품별 사이즈 조회를 위한 VO
 **********************************/
package org.goonagoobob.domain.cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class cartsizeVO {
	private String psid;
	private String pcid;
	private String psize;
	private String pid;
	private String cname;
	
}
