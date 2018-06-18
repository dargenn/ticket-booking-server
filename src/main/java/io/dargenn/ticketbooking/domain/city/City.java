package io.dargenn.ticketbooking.domain.city;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CITIES")
@Data
@EqualsAndHashCode(callSuper = false)
public class City extends ResourceSupport implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long cityId;

    @Column
    private String name;
}
