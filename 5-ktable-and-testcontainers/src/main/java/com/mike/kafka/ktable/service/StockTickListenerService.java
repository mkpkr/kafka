package com.mike.kafka.ktable.service;

import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.mike.kafka.ktable.bindings.ChannelBindings;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

/**
 * Create a notification from an event and send to notification channel
 */
@Service
@Slf4j
@EnableBinding(ChannelBindings.class)
public class StockTickListenerService {
	
	/*
	 * This just seems to recieve every value as its sent to Kafka, in the video it waited until commit.interval.ms before the KTable was received
	 */
	@StreamListener(ChannelBindings.STOCK_INPUT)
	public void process(KTable<String, String> input) {
		input.filter((k,v) -> k.contains("HDFCBANK"))
		     .toStream()
		     .foreach((k,v) -> log.info("##### Key={}; Value={}", k, v));
	}

}
