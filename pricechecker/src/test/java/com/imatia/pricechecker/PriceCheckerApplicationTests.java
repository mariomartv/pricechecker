package com.imatia.pricechecker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceCheckerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test1_getPriceAt_2020_06_14_10_00() throws Exception {
		mockMvc.perform(get("/api/prices")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("date", "2020-06-14 10:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price", is(35.50)));
	}

	@Test
	void test2_getPriceAt_2020_06_14_16_00() throws Exception {
		mockMvc.perform(get("/api/prices")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("date", "2020-06-14 16:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price", is(25.45)));
	}

	@Test
	void test3_getPriceAt_2020_06_14_21_00() throws Exception {
		mockMvc.perform(get("/api/prices")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("date", "2020-06-14 21:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price", is(35.50)));
	}

	@Test
	void test4_getPriceAt_2020_06_15_10_00() throws Exception {
		mockMvc.perform(get("/api/prices")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("date", "2020-06-15 10:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price", is(30.50)));
	}

	@Test
	void test5_getPriceAt_2020_06_16_21_00() throws Exception {
		mockMvc.perform(get("/api/prices")
						.param("brandId", "1")
						.param("productId", "35455")
						.param("date", "2020-06-16 21:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price", is(38.95)));
	}

}
