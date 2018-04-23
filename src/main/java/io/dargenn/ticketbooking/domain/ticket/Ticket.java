package io.dargenn.ticketbooking.domain.ticket;

import io.dargenn.ticketbooking.domain.flight.Flight;
import io.dargenn.ticketbooking.domain.passenger.Passenger;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TICKETS")
@Data
public class Ticket implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column
    private String code;
}
