package com.mike.kafka.restproducer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mike.kafka.restproducer.model.Message;
import com.mike.kafka.restproducer.service.KafkaService;

@RestController
@RequestMapping("/v1/kafka")
public class MessageController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/{topic}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> sendMessage(@PathParam("topic") String topic, 
			                                  @RequestParam("key") Optional<String> key, 
			                                  @Valid @RequestBody Message message) {
		String actualKey = key.orElse("default-key");
		kafkaService.publish(topic, actualKey, message.getData());
		
		return ResponseEntity.ok(String.format("Success, sent to topic %s: %s - %s", topic, actualKey, message.getData()));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> handleConstraintViolation(ConstraintViolationException e) {
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(v -> errors.add(v.getPropertyPath() + ": " + v.getMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<List<ObjectError>> handleBindException(BindException e) {
		return new ResponseEntity<>(e.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
