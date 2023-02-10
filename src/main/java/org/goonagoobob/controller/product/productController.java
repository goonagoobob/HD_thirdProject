/*********************************
 * @function : Product Controller 
 * @author : 조일우
 * @Date : Feb 6. 2023
 * 상품 상세 Controller 추가 Feb 6. 2023
 * 상품 컬러 변경 기능 추가 Feb 7. 2023
 * 상품 카테고리 리스트 호출 Feb 10. 2023
 *********************************/

package org.goonagoobob.controller.product;

import java.util.List;

import org.goonagoobob.domain.product.brandVO;
import org.goonagoobob.domain.product.depth1VO;
import org.goonagoobob.domain.product.productColorVO;
import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.service.product.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class productController {
//	@Autowired
//	private ProductService productService;
	@Autowired
	private productService service;
	@GetMapping("/productList")
	public void ProductList(@RequestParam(value = "brand", required=false) String brand,
			@RequestParam(value = "depth1", required=false) String depth1,
			@RequestParam(value = "depth2", required=false) String depth2,
			@RequestParam(value = "depth3", required=false) String depth3,
			@RequestParam(value = "Piter", required=false, defaultValue = "1") int Piter,
			@RequestParam(value = "productNum", required=false, defaultValue = "8") int productNum,
			@RequestParam(value = "orderBy", required=false, defaultValue = "0") int orderBy,
			@RequestParam(value = "depth", required=false, defaultValue = "0") int depth,
			Model model
			) {
		depth1 = "남성";
		depth = 2;
		List<productCommonVO> VOList = service.getList(brand, depth1, depth2, depth3, orderBy, Piter, productNum);
		List<String> ctgr = service.getCtgrList(brand, depth1, depth2, depth3);
		System.out.println(VOList);
		model.addAttribute("brand",brand);
		model.addAttribute("depth1",depth1);
		model.addAttribute("depth2",depth2);
		model.addAttribute("depth3",depth3);
		model.addAttribute("productVO", VOList);
		model.addAttribute("ctgrList", ctgr);
		if(depth == 1) {
			model.addAttribute("depth",brand);
		} else if(depth == 2) {
			model.addAttribute("depth",depth1);
		}
	}
	@GetMapping("/productDetail")
	public void Productdetail(@RequestParam(value = "pid", required=false) String pid, @RequestParam(value = "pcid", required=false) String pcid,Model model) {
        pid = "TM2CAWPC270W";
		pcid = "TM2CAWPC270W_OH";

		productCommonVO vo = service.getPDetail(pid);
		System.out.println(vo);
		System.out.println("conrotller");
		model.addAttribute("productVO", vo);
		model.addAttribute("pcid", pcid);
	}
	
	@GetMapping("/colorChg")
	@ResponseBody
	public productColorVO colorChg(@RequestParam(value = "pcid", required=false) String pcid) {
		System.out.println("ajax in");
		productColorVO vo = service.getPColor(pcid);
		System.out.println(vo);
		return vo;
	}
	
	@GetMapping("/getBrdCtgr")
	@ResponseBody
	public List<brandVO> getBrdCtgr() {
		List<brandVO> vo = service.getBrd();
		return vo;
	}
	
	@GetMapping("/getCtgr")
	@ResponseBody
	public List<depth1VO> getCtgr() {
		List<depth1VO> vo = service.getCtgr();
		System.out.println(vo);
		return vo;
	}
//	@GetMapping("/productDetail")
//	public void prod() {
//		
//	}
}
