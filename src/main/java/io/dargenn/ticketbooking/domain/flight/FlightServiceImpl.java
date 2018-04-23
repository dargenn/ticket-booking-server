package io.dargenn.ticketbooking.domain.flight;

import com.github.javafaker.Faker;
import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.passenger.Passenger;
import io.dargenn.ticketbooking.domain.passenger.PassengerRepository;
import io.dargenn.ticketbooking.domain.ticket.Ticket;
import io.dargenn.ticketbooking.domain.ticket.TicketRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlightServiceImpl implements FlightService {
    private final @NonNull FlightRepository repository;
    private final @NonNull TicketRepository ticketRepository;
    private final @NonNull PassengerRepository passengerRepository;

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

    @Override
    public Flight findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public String bookFlight(Long flightId) {
        Flight flight = repository.findById(flightId);
        Passenger passenger = createRandomPassenger();
        passenger = passengerRepository.save(passenger);
        Ticket ticket = createTicket(flight, passenger);
        return ticketRepository.save(ticket).getCode();
    }

    private Ticket createTicket(Flight flight, Passenger passenger) {
        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setPassenger(passenger);
        ticket.setCode(UUID.randomUUID().toString());
        return ticket;
    }

    private Passenger createRandomPassenger() {
        Passenger passenger = new Passenger();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        return passenger;
    }
}
