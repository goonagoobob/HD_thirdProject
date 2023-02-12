package org.goonagoobob.security.handler;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class customFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("customeFailureHandler 들어왔나요");
		String errorMessage;
		
		if(exception instanceof BadCredentialsException) {
			errorMessage = "아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
		}
		else if (exception instanceof  InternalAuthenticationServiceException) {
			errorMessage = "내부 시스템 문제로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의하세요.";
		}
		else if (exception instanceof UsernameNotFoundException) {
			errorMessage = "존재하지 않는 계정입니다. 회원가입 후 로그인해주세요.";
		}
		else if (exception instanceof AuthenticationCredentialsNotFoundException) {
			errorMessage = "인증 요청이 거부되었습니다. 관리자에게 문의하세요.";
		}
		else {
			errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의하세요";		
		}
		
		errorMessage = URLEncoder.encode(errorMessage, "UTF-8"); //한글 인코딩 깨진 문제 방지
		
		System.out.println("에러 메시지 : " + errorMessage);
		System.out.println("다음 url : " + "/member/auth/login?error=true&exception="+errorMessage);
		
		setDefaultFailureUrl("/member/auth/login?error=true&exception="+errorMessage);
		super.onAuthenticationFailure(request, response, exception);
	}
	
}
