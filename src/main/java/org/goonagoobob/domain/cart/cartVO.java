package org.goonagoobob.domain.cart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class cartVO {
	
	private String mid;
	private String psid;
	private int pquantity;
	private String pcimg1;
	private String bname;
	private int pcprice;
	private String pname;
	private String pccolorcode;
	private String psize;
}
