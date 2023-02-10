package org.goonagoobob.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.member.memberJoin;

@Mapper
public interface memberMapper {
	//DB부르기
		public int joinMemberAccount(memberJoin mJ);
		public memberAccount selectById(String mid);
		public String checkPassword(String mid);
		public String findId(String mname, String mbirth);
		public int updateMemberInfo(memberChangeInfo mCI);
		public int emailDoubleCheck(String mid, String memail);
		public int memberOut(String mid);
		public int changePassword(String mid, String mpassword);
}

