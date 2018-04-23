package io.dargenn.ticketbooking.soap;

import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.city.CityService;
import io.dargenn.ticketbooking.domain.flight.Flight;
import io.dargenn.ticketbooking.domain.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "io.dargenn.ticketbooking.soap.FlightWebService", targetNamespace = "io.dargenn.ticketbooking")
public class FlightWebServiceImpl extends SpringBeanAutowiringSupport implements FlightWebService {
    @Autowired private FlightService flightService;
    @Autowired private CityService cityService;

    @Override
    public List<Flight> getFlightsByCities(String from, String to) {
        City cityFrom = cityService.findByName(from);
        City cityTo = cityService.findByName(to);
        return flightService.findByFromAndTo(cityFrom, cityTo);
    }

    @Override
    public List<Flight> getFlightsByCitiesAndDates(String from, String to, Date departure) {
        City cityFrom = cityService.findByName(from);
        City cityTo = cityService.findByName(to);
        return flightService.findByFromAndToAndDepartureDate(cityFrom, cityTo, departure);
    }

    @Override
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @Override
    public Flight findById(Long id) {
        return flightService.findById(id);
    }

    @Override
    public String bookFlight(Long flightId) {
        return flightService.bookFlight(flightId);
    }
}
