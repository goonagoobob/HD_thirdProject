package org.goonagoobob.mapper.member;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberJoin;
import org.goonagoobob.service.member.memberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class memberServiceTests {
	
	@Autowired
	private memberService service;
	
	@Test
	public void selectById() {
		memberAccount mA = service.selectById("user1");
		System.out.println(mA);
	}
	
	@Test
	public void insertServiceTest() {
		memberJoin mJ = new memberJoin("self3", "1111", "self3", "self3", "self3", "self3", "self2", "self2", "1998/10/19", 0);
		System.out.println(service.joinMemberAccount(mJ));
	}
	
	@Test
	public void findId() {
		System.out.println(service.findId("user2", "98/10/19"));
	}
}
