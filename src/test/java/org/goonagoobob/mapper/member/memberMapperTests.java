package org.goonagoobob.mapper.member;

import java.sql.SQLException;
import java.text.ParseException;

import org.goonagoobob.domain.member.memberAccount;
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
			memberAccount mA = new memberAccount();
			mA.setMid("user1");
			mA.setMpassword(mpassword);
			mA.setMphone("01000000001");
			mA.setMgender(0);
			mA.setMzipcode("01337");
			mA.setMaddress1("user1주소");
			mA.setMaddress2("user1상세주소");
			mA.setMbirth("1998/10/19");
			mA.setMname("user1");
			mA.setMemail("user1@email");
			memberMapper.joinMemberAccount(mA);
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
}
