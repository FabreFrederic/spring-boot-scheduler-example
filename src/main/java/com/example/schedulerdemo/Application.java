package com.example.schedulerdemo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class Application {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	@Bean
	public JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
		return new JmsMessagingTemplate(jmsTemplate);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
