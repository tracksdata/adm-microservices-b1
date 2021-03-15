package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.CheckIn;
import com.cts.flight.service.CheckinService;

@RestController
@CrossOrigin
@RequestMapping("/api/checkin")
public class CheckinrestController {

	@Autowired
	private CheckinService checkinService;

	@PostMapping("/{bookingId}")
	public ResponseEntity<Object> checkin(@PathVariable int bookingId) {
		
		if(checkinService.getCheckinInfoByBookingId(bookingId)!=null) {
			return new ResponseEntity<Object>("Booking ID "+bookingId+" already checkin. can not recheckin.",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(checkinService.checkIn(bookingId),HttpStatus.OK);
	}

	@GetMapping("/{bookingId}")
	public CheckIn checkinByBookingId(@PathVariable int bookingId) {
		return checkinService.getCheckinInfoByBookingId(bookingId);
	}

	@GetMapping("/byCheckinId/{checkinId}")
	public CheckIn checkinByCheckinId(@PathVariable int checkinId) {
		return checkinService.getCheckinInfoByCheckinId(checkinId);
	}
}
