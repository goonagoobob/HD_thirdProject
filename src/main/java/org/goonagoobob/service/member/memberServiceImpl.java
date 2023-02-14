
/*********************************
 * @function : 회원 Service 구현
 * @author : 이세은
 * @Date : Feb 12. 2023
 * 
 *********************************/

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
	
	
	//mid로 회원 전체 정보 불러오기
	@Override
	public memberAccount selectById(String mid) {
		memberAccount mA;
		mA = memberMapper.selectById(mid);
		return mA;
	}


	//회원가입 폼 정보 입력받아, insert 하기
	@Override
	public int joinMemberAccount(memberJoin mj) {
		//비밀번호 encoding
		String mpassword = passwordEncoder.encode(mj.getMpassword()); 
		mj.setMpassword(mpassword);
		
		int result = memberMapper.joinMemberAccount(mj);	
		return result;
	}
	
	//mid를 통해 비밀번호 맞는지 확인하기
	@Override
	public String checkPassword(String mid) {
		String mpassword = memberMapper.checkPassword(mid);
		return mpassword;
	}

	//이름과 생년월일로 아이디 찾기
	@Override
	public String findId(String mname, String mbirth) {
		String mid = memberMapper.findId(mname, mbirth);
		return mid;
	}
	

	//개인정보변경 폼 입력 받아 수정하기
	@Override
	public int changeMemberInfo(memberChangeInfo memberChangeInfo) {
		int result = memberMapper.updateMemberInfo(memberChangeInfo);
		return result;
	}


	//mid와 memail을 통해 이메일 중복 확인
	@Override
	public int emailDoubleCheck(String mid, String memail) {
		int result = memberMapper.emailDoubleCheck(mid, memail);
		return result;
	}
	
	//회원탈퇴
	@Override
	public int memberOut(String mid) {
		int result = memberMapper.memberOut(mid);
		return result;
	}
	
	//비밀번호 변경
	@Override
	public int changePassword(String mid, String mpassword) {
		String password = passwordEncoder.encode(mpassword);
		System.out.println(password);
		int result = memberMapper.changePassword(mid, password);
		return result;
	}

}
