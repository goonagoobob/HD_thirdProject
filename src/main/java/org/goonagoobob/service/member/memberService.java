package org.goonagoobob.service.member;

import org.goonagoobob.domain.member.memberAccount;

public interface memberService {
	
	public memberAccount selectById(String mid);

}
