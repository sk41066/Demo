package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/flightService")
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;
	@RequestMapping(path = "/addflight", produces = "application/json", 
			method = RequestMethod.POST
			)
	@ResponseBody
	public void addFlight(@RequestParam Long flightId, @RequestParam String flightName,
			@RequestParam String airlineName, @RequestParam String cityFrom, @RequestParam String cityTo,
			 @RequestParam Integer totalSeats, @RequestParam String depDate, @RequestParam String arrDate) {
		 
		LocalDateTime depDateTime = converStringToDateTime(depDate);
		LocalDateTime arrDateTime = converStringToDateTime(arrDate);

		FlightEntity fe = new
		  FlightEntity(flightId,flightName,airlineName,cityFrom,
		  cityTo,totalSeats,depDateTime,arrDateTime);
		flightRepository.save(fe);

	}
	private LocalDateTime converStringToDateTime(String dateTime) {
		 String [] a = dateTime.split("-");

		 return LocalDateTime.of(
				Integer.parseInt(a[0]), 
				Integer.parseInt(a[1]), 
				Integer.parseInt(a[2]), 
				Integer.parseInt(a[3]), 
				Integer.parseInt(a[4])
						);
	}

}
