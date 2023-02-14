
/*********************************
 * @function : 회원 Service 인터페이스
 * @author : 이세은
 * @Date : Feb 12. 2023
 * 
 *********************************/

package org.goonagoobob.service.member;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.member.memberJoin;

public interface memberService {
	public int joinMemberAccount(memberJoin mj); //회원가입
	public memberAccount selectById(String mid); //id를 통해 회원정보 추출
	public String checkPassword(String mid); //id를 통해 맞는 비밀번호인지 확인
	public String findId(String mname, String mbirth); //이름과 생년월일로 아이디 찾기
	public int changeMemberInfo(memberChangeInfo memberChangeInfo); //개인정보변경
	public int emailDoubleCheck(String mid, String memail); //이메일 중복 확인
	public int memberOut(String mid); //회원 탈퇴
	public int changePassword(String mid, String mpassword); //비밀번호 변경
}
