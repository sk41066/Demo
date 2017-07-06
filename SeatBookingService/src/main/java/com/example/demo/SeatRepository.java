package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SeatRepository extends CrudRepository<SeatEntity, Long> {

	@Query("from SeatEntity a where a.flightId=:flightId and a.seatId=:seatId")
	public SeatEntity findBySeatIdAndFlightId(@Param("flightId") long flightId, @Param("seatId") int seatId);
}
