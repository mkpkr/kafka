package com.mike.kafka.streamprocessor.bindings;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

import com.mike.kafka.streamprocessor.model.in.Event;
import com.mike.kafka.streamprocessor.model.out.DatabaseRecord;
import com.mike.kafka.streamprocessor.model.out.Notification;

public interface ChannelBindings {
	
	public static String EVENT_INPUT = "event-input-channel";
	public static String NOTIFICATION_OUTPUT = "notification-output-channel";
	public static String DATABASE_OUTPUT = "database-output-channel";

	@Input(EVENT_INPUT)
	KStream<String, Event> eventInputStream();

}
