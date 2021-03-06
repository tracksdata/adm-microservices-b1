package com.cts.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.FlightInfo;
import com.cts.flight.entity.Inventory;
import com.cts.flight.model.SearchQuery;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private FlightDao flightDao;

	public void updateInventory(String flightNumber, LocalDate flightDate, int newInventory) {

		Flight flight = flightDao.findFlightByFlightNumberAndFlightDate(flightNumber, flightDate);
		if (flight != null) {
			Inventory inv = flight.getInventory();
			inv.setCount(inv.getCount() - newInventory);
			flight.setInventory(inv);
			flightDao.save(flight);
			
		} else {
			throw new RuntimeException(">>>>> Error Occured <<<<<<");
		}

	}

	@Override
	public List<Flight> searchFlight(String origin,String destination,LocalDate flightDate,int numberofPassengers) {

		List<Flight> flights = flightDao.findFlightByOriginAndDestinationAndFlightDate(origin,
				destination, flightDate);
		
		   flights.forEach(flight->{
			flight.getAirlineInfo().getFlights().removeIf(ai->!(ai.getFlightNumber().equals(flight.getFlightNumber())));
			
		   });
		
		//flights.stream().filter(flight->flight.getAirlineInfo().getFlights()
		//		.stream(fi->fi.getFlightNumber().equalsTo(flight.getFlightNumber()).collect(Collectors.toList())));

		return flights.stream().filter(flight -> flight.getInventory().getCount() >= numberofPassengers)
				.collect(Collectors.toList());

	}
	
	
	@Override
	public List<Flight> searchFlight(SearchQuery query) {

		List<Flight> flights = flightDao.findFlightByOriginAndDestinationAndFlightDate(query.getOrigin(),
				query.getDestination(), query.getFlightDate());

		return flights.stream().filter(flight -> flight.getInventory().getCount() >= query.getNumberofPassengers())
				.collect(Collectors.toList());

	}

	@Override
	public Flight findByFlightNumberABdFlightDate(String flightNumber, LocalDate flightDate) {
		return flightDao.findFlightByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

	@Override
	public Flight findFlightById(int id) {
		return flightDao.findById(id).orElse(null);
	}
	
	
	
	public Flight findByFlightNumberAndFlightDateAndOriginAndDestination(String flightNumber,LocalDate flightDate,String origin,String destination) {
		return flightDao.findByFlightNumberAndFlightDateAndOriginAndDestination(flightNumber, flightDate, origin, destination);
	}
	
	
	

}
