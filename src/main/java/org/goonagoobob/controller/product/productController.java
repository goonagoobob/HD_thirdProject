/*********************************
 * @function : Product Controller 
 * @author : 조일우
 * @Date : Feb 6. 2023
 * 상품 상세 Controller 추가 Feb 6. 2023
 * 
 *********************************/

package org.goonagoobob.controller.product;

import org.goonagoobob.domain.product.productCommonVO;
import org.goonagoobob.service.product.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class productController {
//	@Autowired
//	private ProductService productService;
	@Autowired
	private productService service;
	@GetMapping("/productList")
	public void ProductList() {
		
	}
	@GetMapping("/productDetail")
	public void Productdetail(@RequestParam(value="pcid", required=false) String pcid, Model model) {
        pcid = "TM2CAKOP661W_DN";
		productCommonVO vo = service.getPDetail(pcid);
		model.addAttribute("ProductVO", vo);
	}
}
