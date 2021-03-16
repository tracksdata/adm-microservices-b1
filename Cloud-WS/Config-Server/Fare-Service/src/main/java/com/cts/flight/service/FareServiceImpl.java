package com.cts.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.FareDao;
import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;

@Service
public class FareServiceImpl implements FareService {

	@Autowired
	private FlightDao flightDao;
	@Autowired
	private FareDao fareDao;

	@Override
	public Fare findByFlightNumberAndOriginAndDestination(String flightNumber, String origin, String destination) {

		Flight flight = flightDao.findByFlightNumberAndOriginAndDestination(flightNumber, origin, destination);

		return flight.getFare();
	}

	@Override
	public Fare getFareById(int fareId) {
		// TODO Auto-generated method stub
		return fareDao.findById(fareId).orElse(null);
	}

}
