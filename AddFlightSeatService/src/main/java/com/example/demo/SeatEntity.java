package com.example.demo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SeatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long flightId;
	private int seatId;
	private BigDecimal seatPrice;
	private boolean isAvialable;

	public SeatEntity(Long flightId, int seatId, BigDecimal seatPrice, boolean isAvialable) {
		super();
		this.flightId = flightId;
		this.seatId = seatId;
		this.seatPrice = seatPrice;
		this.isAvialable = isAvialable;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public BigDecimal getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(BigDecimal seatPrice) {
		this.seatPrice = seatPrice;
	}

	public boolean isAvialable() {
		return isAvialable;
	}

	public void setAvialable(boolean isAvialable) {
		this.isAvialable = isAvialable;
	}

}
