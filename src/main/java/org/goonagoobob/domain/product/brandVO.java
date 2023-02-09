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
public class brandVO {
	private String brand;
	private List<depth1VO> depth1VO;
}
