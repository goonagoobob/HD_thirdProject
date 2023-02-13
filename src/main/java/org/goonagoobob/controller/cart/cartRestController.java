/* *********************************
 * @function : CartRestController 
 * @author : 김주혜
 * 장바구니 넣기 구현
 * 선택 상품 삭제 구현
 * 상품 색상 select 구현
 * 상품 사이즈 select 구현
 * 선택 상품 변경 구현
 * 개별 상품 삭제 구현
 **********************************/
package org.goonagoobob.controller.cart;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.goonagoobob.domain.cart.cartcolorVO;
import org.goonagoobob.domain.cart.cartsizeVO;
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
	
	  //상품의 색상 종류 뿌려주기
	  @PostMapping("/list") 
	  @ResponseBody
	  public List<cartcolorVO> cartColor(Principal prin, @RequestParam("psid") String psid, Model model) {
		  log.info("postcolorList controller..."); 
		  String mid = prin.getName();
		  log.info("mid: " + mid + " psid: " + psid); 
		  List<cartcolorVO> cList = service.colorList(mid, psid); 
		  log.info(cList); 
		  model.addAttribute("cList", cList); 
		  return cList;
	  }
	  
	  // 상품 사이즈 뿌려주기
	  @PostMapping("/slist")
	  @ResponseBody
	  public List<cartsizeVO> cartSize(@RequestParam("pcid") String pcid, Model model) {
		  log.info("postsizeList controller");
		  log.info("sizeList" + pcid);
		  List<cartsizeVO> sList = service.sizeList(pcid);
		  model.addAttribute("sList", sList);
		  return sList;
		  
	  }
	  
	 //선택상품 변경
	  @PostMapping("/update")
	  public void cartUpdate(Principal prin, @RequestParam("psid") String psid, @RequestParam("npsid") String npsid, @RequestParam("pquantity") String pquantity, @RequestParam("npquantity") String npquantity) {
	  log.info("updateCart controller"); 
	  String mid = prin.getName();
	  log.info(psid);
	  log.info(npsid);
	  log.info(pquantity);
	  log.info(npquantity);
	  service.cartUpdate(mid, psid, npsid, Integer.parseInt(pquantity), Integer.parseInt(npquantity));
  } 
	  
	 //개별 상품 삭제
	  @PostMapping("/eachdelete")
	  public void cartUpdate(Principal prin, @RequestParam("psid") String psid) {
	  log.info("eachdelete controller"); 
	  String mid = prin.getName();
	  log.info(psid);
	  service.eachdelete(mid, psid);
  } 
	
}
