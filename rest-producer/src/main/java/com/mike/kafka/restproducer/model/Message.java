package com.mike.kafka.restproducer.model;

import lombok.Data;

@Data
public class Message {
	private String topic;
	private String key;
	private String data;
}
