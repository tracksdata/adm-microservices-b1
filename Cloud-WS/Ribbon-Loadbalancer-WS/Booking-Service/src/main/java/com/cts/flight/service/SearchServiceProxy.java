package com.cts.flight.service;

import java.time.LocalDate;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Flight;

@FeignClient(name="search-service") // http://search-service/api/search/findFlight
@RibbonClient(name="search-proxy")
public interface SearchServiceProxy {

	@GetMapping("api/search/findFlight/{flightNumber}/{flightDate}/{origin}/{destination}")
	public Flight findFlight(
			@PathVariable String flightNumber,
			@PathVariable @DateTimeFormat(iso = ISO.DATE)LocalDate flightDate,
			@PathVariable String origin,
			@PathVariable String destination );
	
}
