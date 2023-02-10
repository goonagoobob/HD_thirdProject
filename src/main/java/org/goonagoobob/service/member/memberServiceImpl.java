package org.goonagoobob.service.member;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.member.memberJoin;
import org.goonagoobob.mapper.member.memberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("memberService")
public class memberServiceImpl implements memberService{
	
	@Autowired
	private memberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	@Override
	public memberAccount selectById(String mid) {
		memberAccount mA;
		mA = memberMapper.selectById(mid);
		return mA;
	}



	@Override
	public int joinMemberAccount(memberJoin mj) {
		String mpassword = passwordEncoder.encode(mj.getMpassword());
		mj.setMpassword(mpassword);
		
		int result = memberMapper.joinMemberAccount(mj);	
		return result;
	}
	
	@Override
	public String checkPassword(String mid) {
		String mpassword = memberMapper.checkPassword(mid);
		return mpassword;
	}

	@Override
	public String findId(String mname, String mbirth) {
		String mid = memberMapper.findId(mname, mbirth);
		return mid;
	}
	


	@Override
	public int changeMemberInfo(memberChangeInfo memberChangeInfo) {
		int result = memberMapper.updateMemberInfo(memberChangeInfo);
		return result;
	}



	@Override
	public int emailDoubleCheck(String mid, String memail) {
		int result = memberMapper.emailDoubleCheck(mid, memail);
		return result;
	}
	
	@Override
	public int memberOut(String mid) {
		int result = memberMapper.memberOut(mid);
		return result;
	}
	
	@Override
	public int changePassword(String mid, String mpassword) {
		String password = passwordEncoder.encode(mpassword);
		System.out.println(password);
		int result = memberMapper.changePassword(mid, password);
		return result;
	}

}
