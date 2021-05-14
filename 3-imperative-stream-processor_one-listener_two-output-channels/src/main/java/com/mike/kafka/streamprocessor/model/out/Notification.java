package com.mike.kafka.streamprocessor.model.out;

import lombok.Data;

@Data
public class Notification {
	
	private String type;
	private long timestamp;
	private String data;

}
