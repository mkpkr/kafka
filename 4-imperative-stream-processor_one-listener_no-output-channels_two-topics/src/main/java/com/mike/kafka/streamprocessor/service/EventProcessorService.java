package com.mike.kafka.streamprocessor.service;

import java.util.UUID;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.mike.kafka.streamprocessor.bindings.ChannelBindings;
import com.mike.kafka.streamprocessor.model.in.Event;
import com.mike.kafka.streamprocessor.model.out.DatabaseRecord;
import com.mike.kafka.streamprocessor.model.out.Notification;

import lombok.extern.log4j.Log4j2;

/**
 * Create a notification from an event and send to notification channel
 */
@Service
@Log4j2
@EnableBinding(ChannelBindings.class)
public class EventProcessorService {
	
	@StreamListener(ChannelBindings.EVENT_INPUT)
	public void process(KStream<String, Event> input) {
		KStream<String, Notification> notificationStream = input
				.filter((k, v) -> v.getType().equals("MALFUNCTION"))
				.mapValues(this::createNotification);
		
		KStream<String, DatabaseRecord> dbMessageStream = input
				.mapValues(this::createDatabaseRecord);
		
		notificationStream.to("notification-output-topic");
		dbMessageStream.to("database-output-topic");
	}

	private Notification createNotification(Event event) {
		Notification notification = new Notification();
		notification.setType(event.getType());
		notification.setTimestamp(event.getTimestamp());
		notification.setData(event.getData());
		return notification;
	}
	
	private DatabaseRecord createDatabaseRecord(Event event) {
		DatabaseRecord dbRecord = new DatabaseRecord();
		dbRecord.setKey(UUID.randomUUID().toString());
		dbRecord.setData(event.getData());
		return dbRecord;
	}

}
