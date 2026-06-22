package com.acgp.notification_api.controller;

import com.acgp.notification_api.dto.NotificationRequestDTO;
import com.acgp.notification_api.enums.ChannelType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NotificationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void createEmailNotification() throws Exception {
		NotificationRequestDTO request = new NotificationRequestDTO();
		request.setUserId("123");
		request.setMessage("Hola email");
		request.setChannelType(ChannelType.EMAIL);

		mockMvc.perform(post("/api/notifications")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.data.userId").value("123"))
				.andExpect(jsonPath("$.data.channelType").value("EMAIL"));
	}

	@Test
	void createSmsNotification() throws Exception {
		NotificationRequestDTO request = new NotificationRequestDTO();
		request.setUserId("456");
		request.setMessage("Hola sms");
		request.setChannelType(ChannelType.SMS);

		mockMvc.perform(post("/api/notifications")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.data.userId").value("456"))
				.andExpect(jsonPath("$.data.channelType").value("SMS"));
	}

	@Test
	void validateRequiredMessage() throws Exception {
		String request = """
                {
                  "userId": "123",
                  "channelType": "EMAIL"
                }
                """;

		mockMvc.perform(post("/api/notifications")
						.contentType(MediaType.APPLICATION_JSON)
						.content(request))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value("ERROR"));
	}

	@Test
	void validateInvalidChannel() throws Exception {
		String request = """
                {
                  "userId": "123",
                  "message": "Hola",
                  "channelType": "WHATSAPP"
                }
                """;

		mockMvc.perform(post("/api/notifications")
						.contentType(MediaType.APPLICATION_JSON)
						.content(request))
				.andExpect(status().isBadRequest());
	}

	@Test
	void getNotifications() throws Exception {
		mockMvc.perform(get("/api/notifications"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.data").isArray());
	}
}