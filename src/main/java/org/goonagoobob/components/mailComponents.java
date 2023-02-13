/*********************************
 * @function : 메일 보내기
 * @author : 이세은
 * @Date : Feb 11. 2023.
 * 임시 비밀번호 메일 보내기 Feb 11. 2023
 *********************************/

package org.goonagoobob.components;
 
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class mailComponents {
	private final JavaMailSender javaMailSender;
	
	public void sendMailTest(String email, String nansu) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("[더한섬닷컴] 임시 비밀번호 입니다");
		msg.setText("임시 비밀번호는 " + nansu + " 입니다. \n" +
					"비밀번호 변경을 위해서는 개인정보변경 -> 비밀번호 변경을 해주세요.");
		javaMailSender.send(msg);
	}
}
