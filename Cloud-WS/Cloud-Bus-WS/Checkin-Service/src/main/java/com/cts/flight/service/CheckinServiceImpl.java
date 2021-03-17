package com.cts.flight.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.controller.Sender;
import com.cts.flight.dao.CheckinDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.CheckIn;

@Service
public class CheckinServiceImpl implements CheckinService {
	@Autowired
	private CheckinDao checkinDao;

	private String bookingUrl = "http://localhost:8083/api/booking";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Sender sender;

	@Override
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public CheckIn checkIn(int bookingId) {

		BookingRecord bookingRecord = restTemplate.getForObject(bookingUrl + "/" + bookingId, BookingRecord.class);
		CheckIn checkIn = null;
		if (bookingRecord != null) {
			checkIn = new CheckIn();
			checkIn.setCheckinTime(LocalDateTime.now());
			checkIn.setSeatNumber("A2"); // Dummy Seat Number
			checkIn.setBookingRecord(bookingRecord);
			checkinDao.save(checkIn);

			// Send Check-in Confirmation to the BookingService via checkinQ

			sender.sendCheckinConfirmation(bookingId);

		}

		return checkIn;

	}

	@Override
	public CheckIn getCheckinInfoByBookingId(int bookingId) {
		return checkinDao.findBybookingId(bookingId);
	}

	@Override
	public CheckIn getCheckinInfoByCheckinId(int checkinId) {
		return checkinDao.findById(checkinId).orElse(null);
	}

}
