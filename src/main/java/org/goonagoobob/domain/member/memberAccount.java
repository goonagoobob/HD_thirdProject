/*********************************
 * @function : 회원전체정보 VO
 * @author : 이세은
 * @Date : Jan 30. 2023
 * 
 *********************************/

package org.goonagoobob.domain.member;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class memberAccount {
	private String mid; // 회원아이디
	private String mpassword; // 회원비밀번호
	private String mname; // 회원이름
	private String memail; // 회원이메일
	private String mphone; // 휴대폰번호
	private String mtel; // 전화번호
	private String mzipcode; // 우편번호
	private String maddress1; // 주소1
	private String maddress2; // 주소2
	private String mbirth; // 생년월일
	private int mgender; // 성별
	private String mrefid; // 추천인
	private String mlogintype; // 로그인 유형
	private int mtosno; // 사용자정보제공
	private int menabled; // 계정 활성화 여부
	private String mrole; // member or admin
	private int mgrade; // 회원등급
	private int mmileage; // 마일리지
}
