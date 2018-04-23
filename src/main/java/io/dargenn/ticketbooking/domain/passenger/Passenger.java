package io.dargenn.ticketbooking.domain.passenger;

import io.dargenn.ticketbooking.domain.flight.Flight;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PASSENGERS")
@Data
public class Passenger implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
