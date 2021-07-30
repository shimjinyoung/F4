package com.example.hellopuppyreview;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class HellopuppyReviewApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/review/helloParam").param("name", "심진영"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello~~ 심진영"))
		.andDo(print());
	}

}
