package org.goonagoobob.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.goonagoobob.domain.member.memberJoin;

@Mapper
public interface memberMapper {
	//DB부르기
		public int joinMemberAccount(memberJoin memberJoin);
}

