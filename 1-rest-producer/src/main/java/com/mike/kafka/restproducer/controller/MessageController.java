package com.mike.kafka.restproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mike.kafka.restproducer.model.Message;
import com.mike.kafka.restproducer.service.KafkaService;

@RestController
public class MessageController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/send")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String sendMessage(@RequestBody Message message) {
		kafkaService.publish(message.getTopic(), message.getKey(), message.getData());
		
		return String.format("Success, sent to topic %s: %s - %s", message.getTopic(), message.getKey(), message.getData());
	}

}
