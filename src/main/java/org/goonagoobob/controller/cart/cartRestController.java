package org.goonagoobob.controller.cart;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.goonagoobob.service.cart.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
	  @PostMapping("/insert") 
		  public String cartInsert(Principal principal, @RequestParam("psid") String psid, @RequestParam("pquantity") String pquantity) {
		  log.info("cartInsert controller"); 
		  
		  log.info(psid); 
		  log.info(pquantity);
		  
		  String mid = principal.getName(); 
		  service.cartInsert(mid, psid, Integer.parseInt(pquantity));
		  
		  return "성공"; 
	  }
	 
	
	
	@RequestMapping(value="/seldelete", method=RequestMethod.POST)
	
	public ResponseEntity<String> selectDelete(Principal principal,@RequestBody Map<String,Object> map) {
		log.info("cartDelete controller");
		String entryNum = (String)(map.get("entryNumber"));
		String[] entryNum1 = entryNum.split(",");
		List<String> entryNumber = Arrays.asList(entryNum1);
		String mid = principal.getName();
		
		service.selectDelete(mid, entryNumber);
		
		return new ResponseEntity<>("s",HttpStatus.OK);
	}
	
	
	
}
