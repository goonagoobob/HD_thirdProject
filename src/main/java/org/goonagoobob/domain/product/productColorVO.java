/*********************************
 * @function : Product VO
 * @author : 조일우
 * @Date : Feb 6. 2023
 * 상품 VO 추가 Feb 6. 2023
 * 
 *********************************/

package org.goonagoobob.domain.product;

import java.util.List;

import lombok.Data;

@Data
public class productColorVO {
	private String pcid;
	private String pcimg1;
	private String pcimg2;
	private String pcimg3;
	private String pcchipimg;
	private String pccolorcode;
	private int pcprice; 
	private String preleasedate;
	private List<productStockVO> psVO;
}
