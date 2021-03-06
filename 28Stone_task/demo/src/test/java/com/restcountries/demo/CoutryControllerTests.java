package com.restcountries.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CoutryControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getCountriesTest() throws Exception {
		this.mockMvc.perform(get("/eu")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void get10CountriesWithBiggestAreaTest() throws Exception {
		this.mockMvc.perform(get("/eu/area")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void get10CountriesWithBiggestPopulationTest() throws Exception {
		this.mockMvc.perform(get("/eu/population")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void get10CountriesWithBiggestDensityTest() throws Exception {
		this.mockMvc.perform(get("/eu/density")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
