package com.mike.kafka;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.kafka.test.utils.KafkaTestUtils.consumerProps;
import static org.springframework.kafka.test.utils.KafkaTestUtils.getRecords;
import static org.springframework.kafka.test.utils.KafkaTestUtils.producerProps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@DirtiesContext
@EmbeddedKafka(controlledShutdown=false, 
               partitions=1,
               topics={"input-topic", "output-topic"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
                properties = {"server.port=0",
        		              "spring.autoconfigure.exclude=org.springframework.cloud.stream.test.binder.TestSupportBinderAutoConfiguration"})
public class EmbeddedKafkaTests {

	@Autowired
    EmbeddedKafkaBroker embeddedKafka;

//    @Autowired
//    StreamsBuilderFactoryBean streamsBuilderFactoryBean;

//    static Consumer<String, String> consumer;

//    @AfterAll
//    public static void tearDown() {
//        consumer.close();
//    }

    @Test
    public void SimpleProcessorApplicationTest() {
        Set<String> actualResultSet = new HashSet<>();
        Set<String> expectedResultSet = new HashSet<>();
        expectedResultSet.add("HELLO1");
        expectedResultSet.add("HELLO2");

        Map<String, Object> senderProps = producerProps(embeddedKafka);
        DefaultKafkaProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<>(senderProps);
        try {
            Map<String, Object> consumerProps = consumerProps("group", "false", embeddedKafka);
            consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
            ConsumerFactory<String, String> cf = new DefaultKafkaConsumerFactory<>(consumerProps);
        	Consumer<String, String> consumer = cf.createConsumer();
        	embeddedKafka.consumeFromAnEmbeddedTopic(consumer, "output-topic");
        	
            KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf, true);
            template.setDefaultTopic("input-topic");

            template.sendDefault("hello1");
            template.sendDefault("hello2");

            int receivedAll = 0;
            while(receivedAll<2) {
                ConsumerRecords<String, String> cr = getRecords(consumer);
                receivedAll = receivedAll + cr.count();
                cr.iterator().forEachRemaining(r -> actualResultSet.add(r.value()));
            }

            assertThat(actualResultSet.equals(expectedResultSet)).isTrue();
        }
        finally {
            pf.destroy();
        }
    }

}
