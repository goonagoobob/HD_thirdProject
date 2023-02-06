package org.goonagoobob.mapper.product;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class productMapperTests {
	
	@Autowired
	private productMapper mapper;
	
	@Test
	public void productDetailTests() {
		System.out.println("hi");
		System.out.println(mapper.test()); 
	}
}
