package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SeatBookingService {
	private EntityManager em;
	@Autowired
	private SeatRepository repository;

	public List<SeatEntity> getSeatDetails(Long flightId) {

		List<SeatEntity> seatList = new ArrayList<SeatEntity>();
		for (SeatEntity seatEntity : repository.findAll()) {
			if (seatEntity.getFlightId().equals(flightId))
				seatList.add(seatEntity);
		}

		return seatList;
	}

	@Transactional
	public String bookSeat(int seatNo, long flightId) {
		System.out.println("inside bookseat");
		SeatEntity si = repository.findBySeatIdAndFlightId(flightId, seatNo);
		if (si.isAvialable()) {
			si.setAvialable(false);
			repository.save(si);
			return String.join("-", "1", "Seats are booked");

		} else {
			return String.join("-", "0", "seat already occupied");
		}

	}
}
