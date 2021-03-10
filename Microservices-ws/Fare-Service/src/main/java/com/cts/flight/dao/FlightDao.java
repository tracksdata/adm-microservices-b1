package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer> {
	
	Flight findByFlightNumberAndOriginAndDestination(String flightNumber,String origin,String destination);
	
}
