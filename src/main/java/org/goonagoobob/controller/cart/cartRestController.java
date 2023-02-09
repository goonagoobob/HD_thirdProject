package org.goonagoobob.controller.cart;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.goonagoobob.service.cart.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/cartRestApi/")
@RequiredArgsConstructor
public class cartRestController {
	
	@Autowired
	private cartService service;
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String cartInsert(@RequestParam(value="psid", required=false) String psid, @RequestParam(value="pquantity", required=false) int pquantity) {
		log.info("cartInsert controller");
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String mid = loggedInUser.getName();
		service.cartInsert(mid, psid, pquantity);
		
		return "/cart/list";
	}
	
	
	@RequestMapping(value="/seldelete", method=RequestMethod.POST)
	
	public ResponseEntity<String> selectDelete(@RequestBody Map<String,Object> map) {
		log.info("cartDelete controller");
		String entryNum = (String)(map.get("entryNumber"));
		String[] entryNum1 = entryNum.split(",");
		List<String> entryNumber = Arrays.asList(entryNum1);
		String mid = (String)map.get("mid");
		/*
		 * for(int i = 0; i < entryNumber.size(); i++) { service.selectDelete(mid,
		 * entryNumber);
		 * 
		 * }
		 */
		service.selectDelete(mid, entryNumber);
		
		return new ResponseEntity<>("s",HttpStatus.OK);
	}
	
	
	
}
