package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SeatConfiguration {

	@Bean
	public SeatBookingService SeatBookingService(){
		return new SeatBookingService();
	}
}
