package org.goonagoobob.service.member;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.mapper.member.memberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class memberServiceImpl implements memberService{
	
	@Autowired
	private memberMapper memberMapper;
	
	
	@Override
	public memberAccount selectById(String mid) {
		memberAccount mA;
		mA = memberMapper.selectById(mid);
		return mA;
	}
}
