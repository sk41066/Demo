package com.flight.search;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FlightEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Id
	private Long flightId;
	private String flightName;
	private String airlineName;
	private String cityFrom;
	private String cityTo;
	private LocalDateTime departureDate;
	private LocalDateTime arriavaleDate;

	private Integer totalSeats;

	@OneToMany(targetEntity=SeatEntity.class, mappedBy="flightId", fetch=FetchType.EAGER)
	private List<SeatEntity> flightSeats;

	public List<SeatEntity> getFlightSeats() {
		return flightSeats;
	}

	public void setFlightSeats(List<SeatEntity> flightSeats) {
		this.flightSeats = flightSeats;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArriavaleDate() {
		return arriavaleDate;
	}

	public void setArriavaleDate(LocalDateTime arriavaleDate) {
		this.arriavaleDate = arriavaleDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

}
