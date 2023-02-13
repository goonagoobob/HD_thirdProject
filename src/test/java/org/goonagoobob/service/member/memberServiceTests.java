/*********************************
 * @function : member Service 테스트 코드
 * @author : 이세은
 * @Date : Feb 9. 2023

 *********************************/

package org.goonagoobob.service.member;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.member.memberJoin;
import org.goonagoobob.service.member.memberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class memberServiceTests {
	
	@Autowired
	private memberService service;
	
	//id로 정보 찾기
	@Test
	public void selectById() {
		memberAccount mA = service.selectById("user1");
		System.out.println(mA);
	}
	
	//회원가입 테스트 
	@Test
	public void insertServiceTest() {
		memberJoin mJ = new memberJoin("self3", "1111", "self3", "self3", "self3", "self3", "self2", "self2", "1998/10/19", 0);
		System.out.println(service.joinMemberAccount(mJ));
	}
	
	//이름과 생년월일로 아이디 찾기
	@Test
	public void findId() {
		System.out.println(service.findId("user2", "98/10/19"));
	}
	
	//개인정보 변경
	@Test
	public void updateMemberInfo() {
		memberChangeInfo mCI = new memberChangeInfo();
		mCI.setMid("user2");
		mCI.setMemail("user2ChangeEmail@");
		mCI.setMname("user2ChangeName");
		mCI.setMbirth("98/10/19");
		
		System.out.println(service.changeMemberInfo(mCI));
	}
	
	//이메일 중복체크
	@Test
	public void emailDoubleCheck() {
		System.out.println(service.emailDoubleCheck("user1", "user3@email"));
	}
	
	//회원탈퇴
	@Test
	public void memberOut() {
		System.out.println(service.memberOut("user7"));
	}
}
