package com.lp.order.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.lp.order.model.OrderEvent;

@Service
public class OrderProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	
	private NewTopic topic;
	private KafkaTemplate<String, OrderEvent> kafkaTemplete;
	
	// constructor
	public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplete) {
		super();
		this.topic = topic;
		this.kafkaTemplete = kafkaTemplete;
	} 
	
	public void sendMessage(OrderEvent event) {
		LOGGER.info(String.format("Order event => %s", event.toString()));
		
		// Create message
		Message<OrderEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		
		kafkaTemplete.send(message);
	}
	 

}
