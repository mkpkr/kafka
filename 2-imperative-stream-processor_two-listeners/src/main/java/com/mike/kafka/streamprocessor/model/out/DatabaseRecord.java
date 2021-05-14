package com.mike.kafka.streamprocessor.model.out;

import lombok.Data;

@Data
public class DatabaseRecord {
	
	private String key;
	private String data;

}
