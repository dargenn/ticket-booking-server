package io.dargenn.ticketbooking.domain.city;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);

    City findByCityId(Long id);
}
