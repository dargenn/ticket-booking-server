package io.dargenn.ticketbooking.domain.city;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CITIES")
@Data
public class City implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;
}
