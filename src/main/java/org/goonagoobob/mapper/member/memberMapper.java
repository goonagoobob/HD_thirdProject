
/*********************************
 * @function : 회원 Mapper
 * @author : 이세은
 * @Date : Feb 10. 2023
 * 
 *********************************/

package org.goonagoobob.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.member.memberJoin;

@Mapper
public interface memberMapper {
	//DB부르기
		public int joinMemberAccount(memberJoin mJ); //회원가입
		public memberAccount selectById(String mid); //id로 회원 정보 가져오기
		public String checkPassword(String mid); //id로 비밀번호 확인
		public String findId(String mname, String mbirth); //이름과 생년월일로 아이디 찾기
		public int updateMemberInfo(memberChangeInfo mCI); //개인정보변경
		public int emailDoubleCheck(String mid, String memail); //이메일 중복 확인
		public int memberOut(String mid); //회원 탈퇴
		public int changePassword(String mid, String mpassword); //비밀번호 변경
}

