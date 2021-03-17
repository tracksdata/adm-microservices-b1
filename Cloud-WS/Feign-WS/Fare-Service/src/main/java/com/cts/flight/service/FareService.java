package com.cts.flight.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Fare;

public interface FareService {

	Fare findByFlightNumberAndOriginAndDestination(String flightNumber, String origin, String destination);
	
	public Fare getFareById(@PathVariable int fareId) ;
	

}