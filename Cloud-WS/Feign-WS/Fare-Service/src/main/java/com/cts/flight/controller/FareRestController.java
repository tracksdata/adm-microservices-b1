package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.Fare;
import com.cts.flight.service.FareService;

@RestController
@CrossOrigin
@RequestMapping("/api/fare")
@RefreshScope
public class FareRestController {

	@Autowired
	private FareService fareService;

	@Value("${fares.discount}")
	private String faresDiscount;

	@GetMapping("/{flightNumber}/{origin}/{destination}")
	public Fare getFare(@PathVariable String flightNumber, @PathVariable String origin,
			@PathVariable String destination) {
		
		System.out.println(">>>>> FARE DISCOUNT :::: "+faresDiscount);
		return fareService.findByFlightNumberAndOriginAndDestination(flightNumber, origin, destination);
	}

	@GetMapping("/{fareId}")
	public Fare getFareById(@PathVariable int fareId) {
		return fareService.getFareById(fareId);
	}

}
