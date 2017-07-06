package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/flightService")
public class SeatServiceController {
	@Autowired
	private SeatRepository seatRepository;

	@RequestMapping(path = "/addseats", produces = "application/json", method = RequestMethod.POST)
	public void addFlightSeats(@RequestParam Long flightId, @RequestParam BigDecimal catACost,
			@RequestParam BigDecimal catBCost) {
		List<SeatEntity> seatEntities = createSeatEntities(flightId, catACost, catBCost);

		seatRepository.save(seatEntities);
	}

	private List<SeatEntity> createSeatEntities(Long flightId, BigDecimal catACost, BigDecimal catBCost) {
		List<SeatEntity> seatEntities = new ArrayList<SeatEntity>();
		for (int i = 1; i <= 50; i++) {
			seatEntities.add(new SeatEntity(flightId, i, catACost, true));
		}
		for (int i = 51; i <= 150; i++) {
			seatEntities.add(new SeatEntity(flightId, i, catBCost, true));
		}
		return seatEntities;
	}
}
