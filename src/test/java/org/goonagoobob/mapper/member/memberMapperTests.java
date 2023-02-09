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
	
	@Test
	public void selectByID() {
		String mid="user1";
		System.out.println(memberMapper.selectById(mid));
	}
	
	@Test
	public void findId() {
		String mname = "user2ChangeName";
		String mbirth = "98/10/19";
		
		System.out.println(memberMapper.findId(mname, mbirth));
	}
	
	
	@Test
	public void changeMemberInfo() {
		memberChangeInfo mCI = new memberChangeInfo();
		mCI.setMid("user2");
		mCI.setMemail("user2ChangeEmail@");
		mCI.setMname("user2ChangeName");
		mCI.setMbirth("98/10/19");
		System.out.println(memberMapper.updateMemberInfo(mCI));
	}
	
	@Test
	public void emailDoubleCheck() {
		System.out.println(memberMapper.emailDoubleCheck("user1", "user3@email"));
	}
}
