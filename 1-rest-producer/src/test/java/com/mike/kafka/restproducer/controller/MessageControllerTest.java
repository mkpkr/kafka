package com.mike.kafka.restproducer.controller;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.mike.kafka.restproducer.service.KafkaService;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(MessageController.class)
class MessageControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	KafkaService kafkaService;
	
	@Test
	void testMessageSentOk() throws Exception {
		mockMvc.perform(post("/send/{topic}", "some-topic")
				.param("key", "some-key")
				.contentType(MediaType.APPLICATION_JSON)
		        .content("{\"data\":\"my data\","
		        		 + "\"something\":\"100.0\"}"))
		        .andExpect(status().isOk())
		        .andDo(document("/send", pathParameters(
		        		parameterWithName("topic").description("The topic to send the message.")
		        	   )));
	}
	
	@Test
	void testNotReadable() throws Exception {
		mockMvc.perform(post("/send/some-topic")
				        .contentType(MediaType.APPLICATION_JSON)
				        .content("{\"not json\"}")).andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	void testBindException() throws Exception {
		mockMvc.perform(post("/send/some-topic")
				        .contentType(MediaType.APPLICATION_JSON)
				        .content("{\"invalidKey\":\"value\"}")).andExpect(status().isUnprocessableEntity());
	}
	
	/*
	 * Not working - constraint violations are showing up as MethodArgumentNotValidException (subclass of BindException)
	 */
//	@Test
//	void testConstraintViolations() throws Exception {
//		mockMvc.perform(post("/send")
//				        .contentType(MediaType.APPLICATION_JSON)
//				        .content("{\"data\":\"a\","
//				        		+ "\"something\":\"1200.0\"}")).andExpect(status().isBadRequest());
//	}

}
