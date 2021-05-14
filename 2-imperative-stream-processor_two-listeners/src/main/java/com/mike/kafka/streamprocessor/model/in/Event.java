package com.mike.kafka.streamprocessor.model.in;

import lombok.Data;

@Data
public class Event {
	
	private String type;
	private long timestamp;
	private String location;
	private String data;

}
