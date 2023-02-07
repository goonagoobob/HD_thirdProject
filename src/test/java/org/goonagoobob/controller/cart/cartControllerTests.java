package org.goonagoobob.controller.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@AutoConfigureMockMvc
public class cartControllerTests {
	@Autowired
	private MockMvc mvc;
	
	/*
	 * @Test public void cartList() throws Exception{
	 * mockMvc.perform(MockMvcRequestBuilders.get("/list").accept(MediaType.
	 * TEXT_HTML)) .andExpect(MockMvcResultMatchers.status().isOk()) }
	 */

}
