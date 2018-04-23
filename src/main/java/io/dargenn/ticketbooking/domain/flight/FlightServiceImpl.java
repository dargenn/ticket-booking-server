package io.dargenn.ticketbooking.domain.flight;

import io.dargenn.ticketbooking.domain.city.City;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlightServiceImpl implements FlightService {
    private final @NonNull FlightRepository repository;

    @Override
    public List<Flight> findByFromAndTo(City from, City to) {
        return repository.findByFromAndTo(from, to);
    }

    @Override
    public List<Flight> findByFromAndToAndDepartureDate(City cityFrom, City cityTo, Date departure) {
        return repository.findByFromAndToAndDepartureDateGreaterThan(cityFrom, cityTo, departure);
    }

    @Override
    public List<Flight> findAll() {
        return repository.findAll();
    }
}
