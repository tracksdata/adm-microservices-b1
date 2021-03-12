package com.cts.flight.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestRestController {
	
	@Autowired
	private Sender sender;

	@GetMapping
	public String updateBookingInfo(){
	
		Map<String, Object> data=new HashMap<>();
		
		data.put("flightNumber", "AI-530");
		data.put("date", LocalDate.of(2021, 02, 07));
		data.put("seatsUpdated",9);
		
		sender.sendData(data);
		
		return "Booking Information updated..";
	}
	
}
