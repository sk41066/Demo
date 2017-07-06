package com.flight.search;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 
 * @author saurabh Service class for flight search servie
 *
 */
class FlightSearchService {

	@Autowired
	private FlightRepository flightRepository;

	public List<SearchResultEntity> getAllFlightsDetails(SearchParam searchParam) {
		Iterable<FlightEntity> allFlights = flightRepository.findAll();
		return filterFilesOnSearchCriteria(searchParam, allFlights);

	}

	private List<SearchResultEntity> filterFilesOnSearchCriteria(SearchParam searchParam,
			Iterable<FlightEntity> allFlights) {
		List<SearchResultEntity> resultEntity = new ArrayList<SearchResultEntity>();
		String cityTo = searchParam.getCityTo();
		String cityFrom = searchParam.getCityFrom();
		String date = searchParam.getDate();
		StringBuilder filterString = new StringBuilder().append(cityTo).append(cityFrom).append(date);
		System.out.println("value of fileterCriteria " + filterString);
		for (FlightEntity flight : allFlights) {
			StringBuilder flightDetail = new StringBuilder().append(flight.getCityTo()).append(flight.getCityFrom());

			flightDetail.append(createDateValue(flight));
			System.out.println("value of flightDetail " + flightDetail);

			if (flightDetail.toString().trim().equals(filterString.toString().trim())) {
				boolean seatsAvail = checkSeatsAvialability(searchParam.getTotalSeats(), flight.getFlightSeats());
				if (seatsAvail) {
					resultEntity.add(convertFlightEntityToSearchEntity(flight));
				}
			} else {

			}

		}
		// TODO Auto-generated method stub
		return resultEntity;
	}

	private boolean checkSeatsAvialability(int totalSeats, List<SeatEntity> list) {
		int count = 0;
		for (SeatEntity seat : list) {
			if (seat.isAvialable())
				count++;
			if (count == totalSeats)
				return true;
		}

		return false;
	}

	private Object createDateValue(FlightEntity flight) {
		String day = String.valueOf(flight.getDepartureDate().getDayOfMonth());
		String month = String.valueOf(flight.getDepartureDate().getMonthValue());
		String year = String.valueOf(flight.getDepartureDate().getYear());
		/*String dateValue = day + "-" + month + "-" + year;*/
		String [] str = {day,month,year};
		return String.join("-", str);
	}

	private SearchResultEntity convertFlightEntityToSearchEntity(FlightEntity fi) {
		SearchResultEntity en = new SearchResultEntity();
		en.setCityFrom(fi.getCityFrom());
		en.setCityTo(fi.getCityTo());
		en.setFlightName(fi.getFlightName());
		en.setSeatCostCatA(fi.getFlightSeats().get(1).getSeatPrice());
		en.setSeatCostCatB(fi.getFlightSeats().get(100).getSeatPrice());
		int dayOfMonth = fi.getArriavaleDate().getDayOfMonth();
		int hour = fi.getArriavaleDate().getHour();
		int min = fi.getArriavaleDate().getMinute();
		StringBuilder sb = new StringBuilder().append(String.valueOf(dayOfMonth)).append("-")
				.append(String.valueOf(hour)).append("-").append(String.valueOf(min));
		en.setArrivalTime(sb.toString());
		dayOfMonth = fi.getDepartureDate().getDayOfMonth();
		hour = fi.getDepartureDate().getHour();
		min = fi.getDepartureDate().getMinute();
		sb = new StringBuilder().append(String.valueOf(dayOfMonth)).append("-").append(String.valueOf(hour)).append("-")
				.append(String.valueOf(min));
		en.setDepDate(sb.toString());

		en.setTravelTime(calculateTravelTime(fi.getArriavaleDate(), fi.getDepartureDate()));

		return en;
	}

	private String calculateTravelTime(LocalDateTime arriavaleDate, LocalDateTime departureDate) {
		int days = arriavaleDate.getDayOfMonth() - departureDate.getDayOfMonth();
		int hours = arriavaleDate.getHour() - departureDate.getHour();
		int minutes = arriavaleDate.getMinute() - departureDate.getMinute();
		StringBuilder timeDur = new StringBuilder().append(String.valueOf(days)).append(String.valueOf(hours))
				.append(String.valueOf(minutes));
		return timeDur.toString();
	}

}
