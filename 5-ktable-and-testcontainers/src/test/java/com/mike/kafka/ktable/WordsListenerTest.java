package com.mike.kafka.ktable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.mike.kafka.KafkaTest;

import org.testcontainers.containers.KafkaContainer;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.cloud.stream.test.binder.TestSupportBinderAutoConfiguration",
                classes = KafkaTest.KafkaConfiguration.class)
public class WordsListenerTest extends KafkaTest {

	@Test
	public void send() throws Exception {
		kafkaTemplate.send("words-topic", "key1", "Hello world").get();
		kafkaTemplate.send("words-topic", "key1", "Hello kafka").get();
		
		Thread.sleep(500);

		kafkaTemplate.send("words-topic", "key1", "Hello again").get();
		kafkaTemplate.send("words-topic", "key1", "Hi kafka").get();
		
		Thread.sleep(1000);
	}

}
