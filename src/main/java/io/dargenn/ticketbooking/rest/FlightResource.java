package io.dargenn.ticketbooking.rest;

import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.city.CityService;
import io.dargenn.ticketbooking.domain.flight.Flight;
import io.dargenn.ticketbooking.domain.flight.FlightService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlightResource {
    private final @NonNull FlightService flightService;
    private final @NonNull CityService cityService;

    @GetMapping
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public Flight findById(@PathVariable Long id) {
        return flightService.findById(id);
    }

    @GetMapping("/bookFlight/{id}")
    public String bookFlight(@PathVariable Long id) {
        return flightService.bookFlight(id);
    }

    @GetMapping("/byCities")
    public List<Flight> getFlightsByCities(@RequestParam(value = "from") String from,
                                           @RequestParam(value = "to") String to) {
        City cityFrom = cityService.findByName(from);
        City cityTo = cityService.findByName(to);
        return flightService.findByFromAndTo(cityFrom, cityTo);
    }

    @GetMapping("/byCitiesAndDate")
    public List<Flight> getFlightsByCitiesAndDates(@RequestParam(value = "from") String from,
                                                   @RequestParam(value = "to") String to,
                                                   @RequestParam(value = "departure") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date departure) {
        City cityFrom = cityService.findByName(from);
        City cityTo = cityService.findByName(to);
        return flightService.findByFromAndToAndDepartureDate(cityFrom, cityTo, departure);
    }
}
