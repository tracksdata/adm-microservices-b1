package com.cts.flight;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Receiver {

	@RabbitListener(queues = "TestQ1")
	public void getData(Map<String, Object> bookingData) {
		System.out.println(">>>>>>>>>>> Getting Booking Information  from RabbitMQ for Update <<<<<<<<<<");
		
	
		String flightNumber=(String)bookingData.get("flightNumber");
		LocalDate date= (LocalDate) bookingData.get("date");
		int seats=(int)bookingData.get("seatsUpdated");
		System.out.println("----------------------");
		System.out.println(flightNumber);
		System.out.println(date);
		System.out.println(seats);
		System.out.println("----------------------");

		
		
		
		
	}

}
