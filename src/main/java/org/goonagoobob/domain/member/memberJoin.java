
/*********************************
 * @function : 회원가입정보 VO
 * @author : 이세은
 * @Date : Jan 30. 2023
 * 
 *********************************/

package org.goonagoobob.domain.member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class memberJoin {
	private String mid; // 회원아이디
	private String mpassword; // 회원비밀번호
	private String mname; // 회원이름
	private String memail; // 회원이메일
	private String mphone; // 휴대폰번호
	private String mzipcode; // 우편번호
	private String maddress1; // 주소1
	private String maddress2; // 주소2
	private String mbirth;
	private int mgender; // 성별
	
}
