package com.flight.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/searchService")
public class SearchController {

	@Autowired
	private FlightRepository userRepository;

	@Autowired
	private FlightSearchService flightSearch;
	


	@GetMapping(path = "/flight/{flightId}", produces = "application/json")
	@ResponseBody
	public SearchResultEntity getFlightDetails(@RequestParam Long flightId) {
		
		System.out.println(flightId);
		
		FlightEntity fi =	userRepository.findOne(flightId);
		//return convertFlightEntityToSearchEntity(fi);
		return null;
	}
	@GetMapping(path = "/getflights", produces = "application/json")
	@ResponseBody
	public List<SearchResultEntity> searchFlights(@RequestParam String cityTo,@RequestParam int seats,
			@RequestParam String cityFrom,@RequestParam String date) {
		System.out.println("inside method");
		SearchParam searchParam =  new SearchParam(cityTo,cityFrom,seats,date);
		List<SearchResultEntity> searchResults = flightSearch.getAllFlightsDetails(searchParam);
		
		return searchResults;
	}
	@GetMapping(path = "/test", produces = "application/json")
	@ResponseBody
	public String tests(){
		System.out.println("ssssssss");
		return "working";
	}
	
}
