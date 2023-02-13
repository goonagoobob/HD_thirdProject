/*********************************
 * @function : member Mapper 테스트 코드
 * @author : 이세은
 * @Date : Feb 9. 2023

 *********************************/

package org.goonagoobob.mapper.member;

import java.sql.SQLException;
import java.text.ParseException;

import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.member.memberJoin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class memberMapperTests {
	

	@Autowired
	private memberMapper memberMapper;	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//회원가입 test
	@Test
	public void testInsert() throws SQLException, ParseException{
		
		String mpassword = passwordEncoder.encode("1111");
		System.out.println(mpassword);
		boolean matchResult = passwordEncoder.matches("1111", mpassword);
		if(matchResult) {
			memberJoin mJ = new memberJoin();
			mJ.setMid("test11");
			mJ.setMpassword(mpassword);
			mJ.setMphone("010000000011");
			mJ.setMgender(0);
			mJ.setMzipcode("01337");
			mJ.setMaddress1("test11주소");
			mJ.setMaddress2("test11상세주소");
			mJ.setMbirth("1998/10/19");
			mJ.setMname("user1");
			mJ.setMemail("user1@email");
			memberMapper.joinMemberAccount(mJ);
		}
		
		else {
			System.out.println("insert불가");
		}

		
	}
	
	
	//id로 회원 정보 전체 확인
	@Test
	public void selectByID() {
		String mid="user1";
		System.out.println(memberMapper.selectById(mid));
	}
	
	//비밀번호 인코딩 확인
	@Test
	public void checkPassword() {
		String mid="user1";
		System.out.println(memberMapper.checkPassword(mid));
	}
	
	//id 찾기
	@Test
	public void findId() {
		String mname = "user2ChangeName";
		String mbirth = "98/10/19";
		
		System.out.println(memberMapper.findId(mname, mbirth));
	}
	
	//회원정보 변경
	@Test
	public void changeMemberInfo() {
		memberChangeInfo mCI = new memberChangeInfo();
		mCI.setMid("user2");
		mCI.setMemail("user2ChangeEmail@");
		mCI.setMname("user2ChangeName");
		mCI.setMbirth("98/10/19");
		System.out.println(memberMapper.updateMemberInfo(mCI));
	}
	
	//이메일 중복 확인
	@Test
	public void emailDoubleCheck() {
		System.out.println(memberMapper.emailDoubleCheck("user1", "user3@email"));
	}
	
	//회원 탈퇴
	@Test
	public void memberOut() {
		System.out.println(memberMapper.memberOut("user8"));
	}
	
	//비밀번호 변경
	@Test
	public void changePassword() {
		String mid = "user5";
		String mpassword = "789456";
		System.out.println(memberMapper.changePassword(mid, mpassword));
	}
	
	
}
