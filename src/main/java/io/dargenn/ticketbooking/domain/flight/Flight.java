package io.dargenn.ticketbooking.domain.flight;

import io.dargenn.ticketbooking.domain.city.City;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "FLIGHTS")
@Data
public class Flight implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private City from;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private City to;

    @Column
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column
    @Temporal(TemporalType.TIME)
    private Date departureHour;
}
