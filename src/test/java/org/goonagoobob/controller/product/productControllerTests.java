package org.goonagoobob.controller.product;
//<!--*********************************
//* @function : 상품 관련 Controller Test
//* @author : 조일우
//* @Date : Feb 6. 2023
//* 상품 상세 Controller test 추가 Feb 6. 2023
//* 
//********************************* -->

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class productControllerTests {
	
	@Autowired
	MockMvc mvc;
	
    @Test
    @DisplayName("Test")
    void Hello_Test() throws Exception {
        mvc.perform(get("/product/productDetail")) 
            .andExpect(status().isOk());
    }
}
