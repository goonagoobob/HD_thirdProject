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
