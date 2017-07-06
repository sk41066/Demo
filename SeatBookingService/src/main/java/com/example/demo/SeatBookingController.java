package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/flightService")
public class SeatBookingController {
	@Autowired
	private SeatBookingService seatService;

	public boolean bookSeat(@RequestParam int seatId, @RequestParam String userid) {

		return false;
	}

	@GetMapping(path = "/getSeats", produces = "application/json")
	@ResponseBody
	public List<SeatEntity> getSeatDetails(Long flightId) {

		return seatService.getSeatDetails(flightId);

	}

	@GetMapping(path = "/bookSeats", produces = "application/json")
	@ResponseBody
	public boolean bookSeat(@RequestParam int seatNo, @RequestParam long flightId) {

		seatService.bookSeat(seatNo, flightId);
		return false;
	}

}
