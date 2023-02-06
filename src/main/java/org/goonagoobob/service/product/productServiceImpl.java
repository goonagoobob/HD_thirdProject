package org.goonagoobob.service.product;

import org.goonagoobob.mapper.product.productMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements productService {

	@Autowired
	private productMapper mapper;
	
	@Override
	public void list() {
		
	}

}
