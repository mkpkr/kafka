package com.mike.kafka.streamprocessor.service;

import java.util.UUID;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.mike.kafka.streamprocessor.bindings.ChannelBindings;
import com.mike.kafka.streamprocessor.model.in.Event;
import com.mike.kafka.streamprocessor.model.out.Notification;
import com.mike.kafka.streamprocessor.model.out.DatabaseRecord;

import lombok.extern.log4j.Log4j2;

/**
 * Create a database message from an event and send to database channel
 */
@Service
@Log4j2
@EnableBinding(ChannelBindings.class)
public class EventPersistenceService {
	
	@StreamListener(ChannelBindings.EVENT_INPUT)
	@SendTo(ChannelBindings.DATABASE_OUTPUT)
	public KStream<String, DatabaseRecord> process(KStream<String, Event> input) {
		KStream<String, DatabaseRecord> dbMessageStream = input
				.mapValues(this::createDatabaseRecord);
		
		dbMessageStream.foreach((k,v) -> log.info("Processed event: {}", v.getData()));
		
		return dbMessageStream;
	}

	private DatabaseRecord createDatabaseRecord(Event event) {
		DatabaseRecord dbRecord = new DatabaseRecord();
		dbRecord.setKey(UUID.randomUUID().toString());
		dbRecord.setData(event.getData());
		return dbRecord;
	}

}
