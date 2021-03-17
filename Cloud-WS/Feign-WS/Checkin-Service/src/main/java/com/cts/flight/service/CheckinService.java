package com.cts.flight.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.entity.CheckIn;

public interface CheckinService {

	RestTemplate restTemplate();

	CheckIn checkIn(int bookingId);

	CheckIn getCheckinInfoByBookingId(int bookingId);

	CheckIn getCheckinInfoByCheckinId(int checkinId);

}