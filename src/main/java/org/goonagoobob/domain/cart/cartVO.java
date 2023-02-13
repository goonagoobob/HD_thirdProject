/*********************************
 * @function : cartVO 
 * @author : 김주혜
 * 카트 목록 탐색을 위한 VO
 *********************************/

package org.goonagoobob.domain.cart;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class cartVO {
	
	private String mid;
	private String psid;
	private String psid1;
	private int pquantity;
	private String pcimg1;
	private String bname;
	private int pcprice;
	private String pname;
	private String pccolorcode;
	private String psize;
	private String pid;
	private String colorname;
	private String pcid;
	
}
