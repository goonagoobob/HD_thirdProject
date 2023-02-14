/*********************************
 * @function : Product Controller 
 * @author : 조일우
 * @Date : Feb 6. 2023
 * 상품 상세 Controller 추가 Feb 6. 2023
 * 상품 컬러 변경 기능 추가 Feb 7. 2023
 * 상품 카테고리 리스트 호출 Feb 10. 2023
 * 상품 리스트 호출 Feb 11. 2023
 * 메인 호출 Feb 12. 2023
 * 상품 상세 리뷰 호출 Feb 13. 2023
 *********************************/

package org.goonagoobob.controller.product;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.domain.product.reviewVO;
import org.goonagoobob.service.product.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/product")
public class productController {
	@Autowired
	private productService service;
	//상품 리스트 카테고리 별 페이징 별 호
	@GetMapping("/productList")
	public void ProductList(@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "depth1", required = false) String depth1,
			@RequestParam(value = "depth2", required = false) String depth2,
			@RequestParam(value = "depth3", required = false) String depth3,
			@RequestParam(value = "Piter", required = false, defaultValue = "1") int Piter,
			@RequestParam(value = "productNum", required = false, defaultValue = "8") int productNum,
			@RequestParam(value = "orderBy", required = false, defaultValue = "0") int orderBy, Model model) {
		String depth0 = "";
		if (brand == "") {
			brand = null;
		}
		if (depth1 == "") {
			depth1 = null;
		}
		if (depth2 == "") {
			depth2 = null;
		}
		if (depth3 == "") {
			depth3 = null;
		}
		if (brand != null) {

			if (depth1 != null) {
				if (depth2 != null) {
					depth0 = depth2;
				} else {
					depth0 = depth1;
				}

			} else {
				depth0 = brand;
			}
		} else {
			if (depth2 == null) {
				if (depth3 == null) {
					depth0 = depth2;
				} else {
					depth0 = depth1;

				}
			} else {
				depth0 = depth1;
			}
		}

		List<productCommonVO> VOList = service.getList(brand, depth1, depth2, depth3, orderBy, Piter, productNum);
		List<String> ctgr = service.getCtgrList(brand, depth1, depth2, depth3);
		int count = service.getCount(brand, depth1, depth2, depth3);
		System.out.println(VOList);
		System.out.println("depth0 : " + depth0);
		model.addAttribute("brand", brand);
		model.addAttribute("depth0", depth0);
		model.addAttribute("depth1", depth1);
		model.addAttribute("depth2", depth2);
		model.addAttribute("depth3", depth3);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("Piter", Piter);
		model.addAttribute("productNum", productNum);
		model.addAttribute("productVO", VOList);
		model.addAttribute("ctgrList", ctgr);
		model.addAttribute("count", count);
		if (brand == null) {
			model.addAttribute("depth", depth1);
		} else {
			model.addAttribute("depth", brand);
		}

	}
	//상품 목록 추가 호출 
	@GetMapping("/productListMore")
	@ResponseBody
	public List<productCommonVO> ProductListMore(@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "depth1", required = false) String depth1,
			@RequestParam(value = "depth2", required = false) String depth2,
			@RequestParam(value = "depth3", required = false) String depth3,
			@RequestParam(value = "Piter", required = false, defaultValue = "1") int Piter,
			@RequestParam(value = "productNum", required = false, defaultValue = "8") int productNum,
			@RequestParam(value = "orderBy", required = false, defaultValue = "0") int orderBy) {
		if (brand == "") {
			brand = null;
		}
		if (depth1 == "") {
			depth1 = null;
		}
		if (depth2 == "") {
			depth2 = null;
		}
		if (depth3 == "") {
			depth3 = null;
		}
		List<productCommonVO> VOList = service.getList(brand, depth1, depth2, depth3, orderBy, Piter, productNum);
		System.out.println(VOList);
		return VOList;
	}
	//상품 상세 호출 
	@GetMapping("/productDetail")
	public void Productdetail(@RequestParam(value = "pid", required = false) String pid,
			@RequestParam(value = "pcid", required = false) String pcid, Model model, Principal principal) {
		productCommonVO vo = service.getPDetail(pid);
		System.out.println(vo);
		List<reviewVO> reviewvoList = service.getReview(pid);
		if (principal != null) {
			String psid = service.getMyReview(pid, principal.getName());
			model.addAttribute("psid", psid);
			model.addAttribute("mid", principal.getName());
		}
		model.addAttribute("productVO", vo);
		model.addAttribute("reviewVO", reviewvoList);
		model.addAttribute("pcid", pcid);
	}
	//상품상세 컬러 동적 변
	@GetMapping("/colorChg")
	@ResponseBody
	public productColorVO colorChg(@RequestParam(value = "pcid", required = false) String pcid) {
		System.out.println("ajax in");
		productColorVO vo = service.getPColor(pcid);
		System.out.println(vo);
		return vo;
	}
	//상품 브랜드 카테고리 호출 
	@GetMapping("/getBrdCtgr")
	@ResponseBody
	public List<brandVO> getBrdCtgr() {
		List<brandVO> vo = service.getBrd();
		return vo;
	}
	//상품 브랜드 제외 카테고리 호
	@GetMapping("/getCtgr")
	@ResponseBody
	public List<depth1VO> getCtgr() {
		List<depth1VO> vo = service.getCtgr();
		System.out.println(vo);
		return vo;
	}
	//메인 호출 
	@GetMapping("/main1")
	public void getdsdsCtgr(Model model) {
		List<productCommonVO> newVO = service.getNewList();
		List<productCommonVO> bestVO = service.getBestList();
		int newCount = service.newCount();
		System.out.println(newCount);
		model.addAttribute("bestVO", bestVO);
		model.addAttribute("newVO", newVO);
		model.addAttribute("newCount", newCount);
	}
	//리뷰 등록 
	@PostMapping("/reviewAdd")
	public String reviewAdd(Principal principal,
			@RequestParam(value = "age", required = false, defaultValue = "미 기입") String age,
			@RequestParam("height") String height, @RequestParam("bodyType") String bodyType,
			@RequestParam("enjoySize") String enjoySize, @RequestParam("rating") int rating,
			@RequestParam("realWearSize1") String realWearSize1, @RequestParam("realWearSize2") String realWearSize2,
			@RequestParam("realWearSize3") String realWearSize3,
			@RequestParam("realProductColor") String realProductColor, @RequestParam("headline") String headline,
			@RequestParam("psid") String psid,
			@RequestParam("pcid") String pcid,
			@RequestParam("pid") String pid

	) {
		System.out.println(pid);
		Date today = new Date();
		reviewVO vo = new reviewVO();
		vo.setMID(principal.getName());
		vo.setRV_TEXT(headline);
		vo.setRV_DATE(today);
		vo.setPSID(psid);
		vo.setAGE(age);
		vo.setHEIGHT(height);
		vo.setBODYTYPE(bodyType);
		vo.setENJOYSIZE(enjoySize);
		vo.setRATING(rating);
		vo.setREALWEARSIZE1(Integer.parseInt(realWearSize1));
		vo.setREALWEARSIZE2(Integer.parseInt(realWearSize2));
		vo.setREALWEARSIZE3(Integer.parseInt(realWearSize3));
		vo.setREALPRODUCTCOLOR(Integer.parseInt(realProductColor));	
		service.insertReview(vo);
		System.out.println(vo);
		return "redirect:/product/productDetail?pid="+pid+"&pcid="+pcid;
	}

}
