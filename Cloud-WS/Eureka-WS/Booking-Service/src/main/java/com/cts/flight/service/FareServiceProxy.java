package com.cts.flight.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;

@FeignClient(name = "fare-proxy",url = "http://localhost:8081/api/fare")
public interface FareServiceProxy {
	
	@GetMapping("/{flightNumber}/{origin}/{destination}")
	public Fare getFare(@PathVariable String flightNumber,@PathVariable String origin,@PathVariable String destination);

}
