package org.goonagoobob.domain.product;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class reviewVO {
	private String MID;
	private String RV_TEXT;
	private Date RV_DATE;
	private String  PSID;
	private String AGE;
	private String HEIGHT;
	private String BODYTYPE;
	private String ENJOYSIZE;
	private int RATING;
	private int REALWEARSIZE1;
	private int REALWEARSIZE2;
	private int REALWEARSIZE3;
	private int REALPRODUCTCOLOR;
}
