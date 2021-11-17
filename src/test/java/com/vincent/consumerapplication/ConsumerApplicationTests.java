package com.vincent.consumerapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.ParseException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ConsumerApplicationTests {

	private Event event = new Event("62007075197",188.21,"2022-11-01",
				"VODSWMTTTRBC",false,true);

	private static final String EXPECTED_PAYLOAD = "{ \n" +
			"    \"accountNumber\": \"62007075197\", \n" +
			"    \"transactionAmount\": 188.21, \n" +
			"    \"transactionEffectiveDate\": \"2022-11-01\", \n" +
			"    \"transactionTraceIdentifier\": \"VODSWMTTTRBC\", \n" +
			"    \"marketingConsent\": false, \n" +
			"    \"kycIndicator\": true, \n" +
			"    \"ruleId\": 1, \n" +
			"    \"ruleResult\": \"negative\" \n" +
			"} ";
	@Autowired
	MockMvc mockMvc;

	ConsumerApplicationTests() throws ParseException {
	}

	@Test
	void contextLoads() {
	}
	@Test
	void shouldAcceptAnEventAndReturnAnEnrichedPayload() throws Exception {
		mockMvc.perform(post("/enrich")
				.contentType(APPLICATION_JSON)
				.content(asJsonString(event)))
				.andExpect(status().isOk())
				.andExpect(content().json(EXPECTED_PAYLOAD));
	}
	private String asJsonString(Object o) {
		try {
			return new ObjectMapper().writeValueAsString(o);
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}
