/*********************************
 * @function : 주문내역을 페이징을 위한 VO
 * @author : 차민수
 * @Date : Feb 6. 2023
 *********************************/
package org.goonagoobob.domain.order;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter

public class orderPageDTO {
	private int cnt;
	private List<orderVO> list;
}
