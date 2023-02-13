/*********************************
 * @function : 회원정보, 마이페이지 Controller
 * @author : 이세은, 차민수
 * @Date : Jan 31. 2023. ~ Feb 13.2023
 * 비밀번호 재확인 기능 구현 Feb 10. 2023
 * 비밀번호 변경 기능 구현 Feb 11. 2023
 * 개인정보 변경 기능 구현 Feb 12. 2023
 * 주문 내역을 조회하는 기능 구현 Feb 11. 2023
 *********************************/

package org.goonagoobob.controller.myPage;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.goonagoobob.domain.member.memberAccount;
import org.goonagoobob.domain.member.memberChangeInfo;
import org.goonagoobob.domain.order.Criteria;
import org.goonagoobob.security.service.Message;
import org.goonagoobob.service.member.memberService;
import org.goonagoobob.service.order.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/myPage/")
@AllArgsConstructor
@Log4j2
public class myPageController {
	@Autowired
	private memberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private orderService service;
	
	@GetMapping("/myPage")
	public void myPage(Principal principal, Model model) {
		String mid = principal.getName();
		memberAccount mA = memberService.selectById(mid);
		String address = mA.getMaddress1() + mA.getMaddress2();
		String mileage = Integer.toString(mA.getMmileage());
		
		System.out.println("mileage to String" + mileage);
		System.out.println(address);
		model.addAttribute("address", address);
		model.addAttribute("mileage", mileage);
	}
	
	@GetMapping("/passwordCheck")
	public void passwordCheck() {
		
	}

	
	@GetMapping("/changePassword")
	public void passwordChange() {
	}
	
	
	// GET 방식으로 마이페이지에 유저의 주문 내역을 조회하는 Controller
	// 작성자 : 차민수
	// Feb 11. 2023
	@GetMapping(value = "/orderList")
	public void getList(Criteria cri, Model model) {
		log.info("getList............");
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String mid = loggedInUser.getName();
		System.out.println("controller mid " + mid);
		model.addAttribute("orderList", service.getList(cri, mid));
	}

	
	//로그인 안된 상태로 바로 들어가면 principal 오류가 남 ... 
	@GetMapping("/checkPassword")
	public void checkPassword(Principal principal, Model model) {
		
		log.info("helloooooo");
		System.out.println("hsellooooo");
		String mid = principal.getName();
		System.out.println("로그인한 정보: " + mid);
		//1. mid로 account정보 가져오기
		memberAccount mA = memberService.selectById(mid);
		String mPassword = mA.getMpassword();
		System.out.println(mPassword);
		model.addAttribute("mid", mid);
		
	}
	
	@PostMapping("/checkPasswordForm")
	public String checkPasswordForm(Principal principal, @RequestParam("j_password") String password, Model model) {
		System.out.println("@@@@@@@@password@@@@@@@@@" + password);
		
		String mid = principal.getName();
		System.out.println("form에서 확인을 해보쟝 " + password);
		
		memberAccount mA = memberService.selectById(mid);
		System.out.println("DB에 저장되어 있는 비밀번호 : " + mA.getMpassword());
		
		if (passwordEncoder.matches(password, mA.getMpassword()))
		{
			System.out.println("일치");
			return "redirect:/myPage/changeUserInfo";
			//return "/myPage/changeUserInfo";
		}
		else {
			System.out.println("불일치");
			String message = "비밀번호가 불일치합니다.";
			String error = "true";
			System.out.println(message);
			System.out.println(error);
			model.addAttribute("error" , error);
			model.addAttribute("message" , message);
			return "/myPage/checkPassword";
		}

	}
	
	
	@GetMapping("/changeUserInfo") //로그인 필요
	public void changeUserInfo(Principal principal, Model model) {
		String mid = principal.getName();
		System.out.println(mid);
		
		memberAccount mA = memberService.selectById(mid);
		System.out.println(mA);
		
		model.addAttribute("memberInfo", mA);
	}
	
	@PostMapping("/changeUserInfoForm")
	public String changeUserInfoForm(Principal prin,
			@RequestParam("mid") String mid, 
			@RequestParam("memail") String memail, 
			@RequestParam("mname") String mname, 
			@RequestParam("selYear") String selYear, 
			@RequestParam("selMonth") String selMonth, 
			@RequestParam("selDay") String selDay, HttpSession session) {
		
		System.out.println("@@@@@@changeUserInfoForm 들어옴@@@@@@");
		
		
		memberChangeInfo mCI = new memberChangeInfo();
		String mid2 = prin.getName();
		System.out.println(mid);
		System.out.println(memail);
		System.out.println(mname);
		System.out.println(selYear);
		System.out.println(selMonth);
		System.out.println(selDay);
		
		//session과 연결
		//String sessionId = (String) session.getAttribute(mid);
		
		
		String mbirth = selYear + "/" + selMonth + "/" + selDay ;
		mCI.setMid(mid2);
		mCI.setMemail(memail);
		mCI.setMname(mname);
		mCI.setMbirth(mbirth);
		
		int result = memberService.changeMemberInfo(mCI);
		System.out.println("바뀌었습니깡 ??? " + result + "!!!!");
		
		if (result == 1) {
			return "redirect:/myPage/myPage";
		}		
		return "/myPage/changeUserInfo";
		//예외 처리...
	}
	
	@GetMapping("/memberOut")
	public void memberOut() {
		
	}

}
