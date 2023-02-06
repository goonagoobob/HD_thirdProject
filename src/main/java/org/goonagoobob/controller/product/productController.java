package org.goonagoobob.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class productController {
//	@Autowired
//	private ProductService productService;
	
	@GetMapping("/list")
	public void list() {
		
	}
}
