package com.mike.kafka.ktable.bindings;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;

import com.mike.kafka.ktable.model.StockTick;

public interface ChannelBindings {
	
	public static String STOCK_INPUT = "stock-input-channel";
	public static String WORDS_INPUT = "words-input-channel";

	@Input(STOCK_INPUT)
	KTable<String, String> stockInputStream();
	
	@Input(WORDS_INPUT)
	KStream<String, String> wordsInputStream();

}
