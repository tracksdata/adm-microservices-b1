package com.cts.flight.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {
	
	@Autowired
	private RabbitTemplate rt;
	
	
	@Bean
	public Queue myQueue1() {
		return new Queue("checkinQ",false);
	}
	
	public void sendCheckinConfirmation(Object checkinInfo) {
		rt.convertAndSend("checkinQ",checkinInfo);
	}
	
	

}
