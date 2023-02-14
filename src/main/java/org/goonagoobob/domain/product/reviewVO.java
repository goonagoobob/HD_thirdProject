/*********************************
 * @function : Review VO
 * @author : 조일우
 * @Date : Feb 13. 2023
 * 리뷰 VO 추가 Feb 13. 2023
 * 
 *********************************/

package org.goonagoobob.domain.product;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class reviewVO {
	public reviewVO(String string, String string2, Date today, String string3, String string4, String string5,
			String string6, String string7, int i, int j, int k, int l, int m) {
		// TODO Auto-generated constructor stub
	}
	public reviewVO() {
		// TODO Auto-generated constructor stub
	}
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
