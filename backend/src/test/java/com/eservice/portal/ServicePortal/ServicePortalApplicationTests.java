package com.eservice.portal.ServicePortal;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.MvcResult;





@WebMvcTest(ServicePortalController.class)
@AutoConfigureRestDocs(outputDir = "target/results")
public class ServicePortalApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {

		Map<String,String> admin = new HashMap<>();
		admin.put("userName", "admin@admin.com");
		admin.put("password", "admin");

		Map<String,String> customer = new HashMap<>();
		customer.put("userName", "customer@cust.com");
		customer.put("password", "customer");

		Map<String,String> unknownUser = new HashMap<>();
		unknownUser.put("userName", "");
		unknownUser.put("password", "");

		ObjectMapper objectMapper = new ObjectMapper();

		MvcResult adminMvcResult = this.mockMvc.perform(post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))
		        ).andReturn();
		int adminStatus = adminMvcResult.getResponse().getStatus();
		assertEquals(200, adminStatus);
		String adminContent = adminMvcResult.getResponse().getContentAsString();
		JSONObject adminJsonObj = new JSONObject(adminContent.toString());

		assertEquals(adminJsonObj.getString("type"), "admin");

		MvcResult customerMvcResult = this.mockMvc.perform(post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(customer))
		).andReturn();
		int customerStatus = customerMvcResult.getResponse().getStatus();
		assertEquals(200, customerStatus);
		String customerContent = customerMvcResult.getResponse().getContentAsString();
		JSONObject customerJsonObj = new JSONObject(customerContent.toString());

		assertEquals(customerJsonObj.getString("type"), "customer");

		MvcResult unknownUserMvcResult = this.mockMvc.perform(post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(unknownUser))
		).andReturn();
		int status = unknownUserMvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = unknownUserMvcResult.getResponse().getContentAsString();
		JSONObject jsonObj = new JSONObject(content.toString());

		assertEquals(jsonObj.getString("type"), "null");

	}

}
