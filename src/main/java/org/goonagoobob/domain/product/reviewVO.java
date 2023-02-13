package org.goonagoobob.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class reviewVO {
	private int RNO;
	private String MID;
	private String RV_TEXT;
	private String RV_DATE;
	private String  PSID;
	private String AGE;
	private String HEIGHT;
	private String BODYTYPE;
	private String ENJOYSIZE;
	private int RATING;
	private String REALWEARSIZE1;
	private String REALWEARSIZE2;
	private String REALWEARSIZE3;
	private String REALPRODUCTCOLOR;
}
