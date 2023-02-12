package org.goonagoobob.controller.cart;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.service.cart.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	// 상품 상세페이지에서 카트에 상품 넣어주기
	  @PostMapping("/insert") 
		  public void cartInsert(Principal principal, @RequestParam("psid") String psid, @RequestParam("pquantity") String pquantity) {
		  log.info("cartInsert controller"); 
		  log.info(psid); 
		  log.info(pquantity);
		  
		  String mid = principal.getName(); 
		  service.cartInsert(mid, psid, Integer.parseInt(pquantity));
	  }
	 // 선택 상품 삭제하기
	@RequestMapping(value="/seldelete", method=RequestMethod.POST)
	public ResponseEntity<String> selectDelete(Principal principal,@RequestBody Map<String,Object> map) {
		log.info("cartDelete controller");
		String entryNum = (String)(map.get("entryNumber"));
		String[] entryNum1 = entryNum.split(",");
		List<String> entryNumber = Arrays.asList(entryNum1);
		log.info(entryNumber);
		String mid = principal.getName();
		
		service.selectDelete(mid, entryNumber);
		
	
		return new ResponseEntity<>("s",HttpStatus.OK);
	}
	
	  //psid 상품의 색상 종류 뿌려주기
	  @PostMapping("/list") 
	  @ResponseBody
	  public List<cartcolorVO> cartColor(Principal prin, @RequestParam("psid") String psid, Model model) {
		  log.info("postcartList controller..."); 
		  String mid = prin.getName();
		  log.info("mid: " + mid + " psid: " + psid); 
		  List<cartcolorVO> cList = service.colorList(mid, psid); 
		  log.info(cList); 
		  model.addAttribute("cList", cList); 
		  return cList;
	  }
	 
	
}
