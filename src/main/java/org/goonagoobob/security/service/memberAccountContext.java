package org.goonagoobob.security.service;

import java.util.Collection;

import org.goonagoobob.domain.member.memberAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class memberAccountContext extends User {
	private final memberAccount account;

	public memberAccountContext(memberAccount mA, Collection<? extends GrantedAuthority> authorities) {
		super(mA.getMid(), mA.getMpassword(), authorities);
		this.account = mA; // 찾고 이용할 수 있게끔
	}

	public memberAccount getMemberAccount() {
		return account;
	}
}
