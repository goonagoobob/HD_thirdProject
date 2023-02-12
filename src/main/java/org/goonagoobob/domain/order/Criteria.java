package org.goonagoobob.domain.order;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Criteria {

	private int pageNum; // 페이지 번호
	private int amount; // 개수

	private String type; // 검색 조건
	private String keyword; // 검색 키워드

	// UriComponentsBuilder를 이용하여 링크 생성
	public String getListLink() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount).queryParam("type", this.type).queryParam("keyword", this.keyword);

		return builder.toUriString();
	}// end getList..

	// 검색 조건이 각각 (P, O)로 구성되어 있으므로 pname, oid
	// 검색 조건을 배열로 만들어서 한 번에 처리하기 위함
	public String[] getTypeArr() {
		// 삼항식[Condition Operator] ? TURE : FALSE
		return (type == null) ? new String[] {} : type.split("");
	}// end getType..

	// 기본 페이지를 1페이지에 10개씩 보여줌
	public Criteria() {
		this(1, 100);
	}// end cri...

	// 매개변수로 들어오는 값을 이용하여 조정할 수 있음
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}// end Cri..

}// end class
