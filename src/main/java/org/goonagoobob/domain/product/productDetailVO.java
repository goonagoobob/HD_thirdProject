package org.goonagoobob.domain.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class productDetailVO {
	   private String bname; // 브랜드테이블 브랜드이름
	   private String pname; // 물품테이블 물품이름
	      
	   private String pccolorcode; // 물품색테이블 색상
	   private String pcimg1; // 물품색테이블 이미지 1개
	   private int pcprice; // 물품색테이블 판매가격
	      
	   private String psize; // 물품재고테이블 사이즈
	
}

