/* *********************************
 * @function : CartColorVO
 * @author : 김주혜
 * @Date : Dec 31. 2022.
 * 상품 색상 조회를 위한 VO
 **********************************/
package org.goonagoobob.domain.cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class cartcolorVO {
	private String pcchipimg;
	private String pccolorcode;
	private String pid;
	private String colorname;
	private String mid;	
	private String pcid;
}
