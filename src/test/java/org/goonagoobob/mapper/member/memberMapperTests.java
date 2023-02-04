package org.goonagoobob.mapper.member;

import java.sql.SQLException;
import java.text.ParseException;

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
	
	@Test
	public void test() {
		log.info("hello");
	}
	
	@Test
	public void insertDummies2() throws SQLException, ParseException{
		memberJoin memberJoin = new memberJoin();
		memberJoin.setMid("userAPI6");
		memberJoin.setMpassword("1111");
		memberJoin.setMphone("userAPI6");
		memberJoin.setMgender(0);
		memberJoin.setMzipcode("01337");
		memberJoin.setMaddress1("userAPI6주소");
		memberJoin.setMaddress2("userAPI6상세주소");
		memberJoin.setMbirth("1998/10/19");
		memberJoin.setMname("userAPI6");
		memberJoin.setMemail("userAPI6@email");
		
		memberMapper.joinMemberAccount(memberJoin);
		
	}
}
