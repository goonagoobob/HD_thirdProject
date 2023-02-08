package org.goonagoobob.service.member;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberJoin;

public interface memberService {
	public int joinMemberAccount(memberJoin mj);
	public memberAccount selectById(String mid);
	public String checkPassword(String mid);
}
