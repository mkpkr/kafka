package com.mike.kafka.ktable.service;

import java.util.Arrays;

import org.apache.kafka.streams.kstream.KStream;
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
public class WordsListenerService {
	
	/*
	 * Count number of occurrences of each word, pass in sentences and it will split them and keep track of the words
	 * count() will wait until commit.interval.ms before forwarding data 
	 */
	@StreamListener(ChannelBindings.WORDS_INPUT)
	public void process(KStream<String, String> input) {
		input.flatMapValues(v -> Arrays.asList(v.toLowerCase().split(" "))) // KStream<String, String>  
		     .groupBy((k,v) -> v) // KGroupedStream<String,String>
		     .count() // KTable<String,Long>
		     .toStream() // KStream<String,Long>
		     .foreach((k,v) -> log.info("##### Word={}; Count={}", k, v));
	}

}
