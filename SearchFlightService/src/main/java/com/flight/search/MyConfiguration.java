package com.flight.search;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Bean
	public FlightSearchService FlightSearchService(){
		return new FlightSearchService();
	}

}
