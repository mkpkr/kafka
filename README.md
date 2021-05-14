# rest-producer

A simple REST API that publishes to Kafka using *Spring for Apache Kafka* (KafkaTemplate)

# imperative-stream-processor_two-listeners

Consume and produce messages using *Spring Cloud Stream* and *Kafka Streams* (KStream)

* 1 input channel
* 2 listeners 
* each listener sending to a separate output channel

**Problem here is only one output channel will receive the data because the input channel is one consumer group.**

# imperative-stream-processor_one-listener_two-output-channels

Consume and produce messages using *Spring Cloud Stream* and *Kafka Streams* (KStream)

* 1 input channel
* 1 listener
* 2 output channels

Problem here is the output channels must be same type.

# imperative-stream-processor_one-listener_no-output-channels_two-topics

Consume and produce messages using *Spring Cloud Stream* and *Kafka Streams* (KStream)

* 1 input channel
* 1 listener
* 0 output channels, listener sends directly to 2 topics

# stream-processor-functional

