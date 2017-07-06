package com.flight.search;

import java.time.LocalDateTime;

public class SearchParam {

	private String cityTo;
	private String cityFrom;
	private int totalSeats;
	private String date;
	
	
	public SearchParam(String cityTo, String cityFrom, int totalSeats, String date) {
		super();
		this.cityTo = cityTo;
		this.cityFrom = cityFrom;
		this.totalSeats = totalSeats;
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	
}
