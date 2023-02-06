package org.goonagoobob.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberJoin;

@Mapper
public interface memberMapper {
	//DB부르기
		public int joinMemberAccount(memberAccount memberAccount);
		public memberAccount selectById(String mid);
}

