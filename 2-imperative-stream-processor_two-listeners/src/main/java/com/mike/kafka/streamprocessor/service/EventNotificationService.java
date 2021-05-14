package com.mike.kafka.streamprocessor.service;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.mike.kafka.streamprocessor.bindings.ChannelBindings;
import com.mike.kafka.streamprocessor.model.in.Event;
import com.mike.kafka.streamprocessor.model.out.Notification;

import lombok.extern.log4j.Log4j2;

/**
 * Create a notification from an event and send to notification channel
 */
@Service
@Log4j2
@EnableBinding(ChannelBindings.class)
public class EventNotificationService {
	
	@StreamListener(ChannelBindings.EVENT_INPUT)
	@SendTo(ChannelBindings.NOTIFICATION_OUTPUT)
	public KStream<String, Notification> process(KStream<String, Event> input) {
		KStream<String, Notification> notificationStream = input
				.filter((k, v) -> v.getType().equals("MALFUNCTION"))
				.mapValues(this::createNotification);
		
		notificationStream.foreach((k,v) -> log.info("Processed event: {}", v.getData()));
		
		return notificationStream;
	}

	private Notification createNotification(Event event) {
		Notification notification = new Notification();
		notification.setType(event.getType());
		notification.setTimestamp(event.getTimestamp());
		notification.setData(event.getData());
		return notification;
	}

}
