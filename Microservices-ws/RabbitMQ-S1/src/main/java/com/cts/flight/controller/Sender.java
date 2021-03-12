package com.cts.flight.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sender {
	
	
	private RabbitMessagingTemplate rmt;
	
	@Autowired
	public Sender(RabbitMessagingTemplate rmt) {
		this.rmt=rmt;
	}
	
	
	@Bean
	public Queue myQueue() {
		return new Queue("TestQ1",false);
	}
	
	public void sendData(Map<String, Object> data) {
		System.out.println(">>>>> Updating Booking Info to RabbitMQ <<<<<");
		rmt.convertAndSend("TestQ1",data);
	}
	
	
	
	
	
	

}
