package io.dargenn.ticketbooking.domain.flight;

import io.dargenn.ticketbooking.domain.city.City;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Flight> findByFromAndTo(City from, City to);

    List<Flight> findByFromAndToAndDepartureDate(City cityFrom, City cityTo, Date departure);

    List<Flight> findAll();
}
