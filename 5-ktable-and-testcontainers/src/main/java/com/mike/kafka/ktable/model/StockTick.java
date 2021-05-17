package com.mike.kafka.ktable.model;

import lombok.Value;

@Value
public class StockTick {
	
	private long timestamp;
	private String stockCode;
	private int price;

}
