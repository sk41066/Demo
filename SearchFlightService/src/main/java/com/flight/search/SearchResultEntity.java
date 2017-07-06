package com.flight.search;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SearchResultEntity {

	private String cityTo;
	private String cityFrom;
	private String flightName;
	private BigDecimal seatCostCatA;
	private BigDecimal seatCostCatB;
	private String arrivalTime;
	private String depTime;
	private String travelTime;
	private int totalSeats;
	private String depDate;

	public BigDecimal getSeatCostCatA() {
		return seatCostCatA;
	}

	public void setSeatCostCatA(BigDecimal seatCostCatA) {
		this.seatCostCatA = seatCostCatA;
	}

	public BigDecimal getSeatCostCatB() {
		return seatCostCatB;
	}

	public void setSeatCostCatB(BigDecimal seatCostCatB) {
		this.seatCostCatB = seatCostCatB;
	}



	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getDepDate() {
		return depDate;
	}

	public void setDepDate(String depDate) {
		this.depDate = depDate;
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

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

}
