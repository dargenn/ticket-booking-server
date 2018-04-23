package io.dargenn.ticketbooking.domain.flight;

import io.dargenn.ticketbooking.domain.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFromAndTo(City from, City to);

    List<Flight> findByFromAndToAndDepartureDateGreaterThan(City cityFrom, City cityTo, Date departure);
}
