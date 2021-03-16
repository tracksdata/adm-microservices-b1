package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
@RefreshScope
public class TestRestController {
	
	
	@Value("${sname}")
	private String personName;
	
	
	
	@GetMapping
	public String f1() {
		return "Hello "+personName;
	}
	

}
