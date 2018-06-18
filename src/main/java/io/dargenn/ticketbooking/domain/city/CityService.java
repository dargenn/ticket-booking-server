package io.dargenn.ticketbooking.domain.city;

import java.util.List;

public interface CityService {
    List<City> findAll();

    City save(City city);

    City findByName(String name);

    City findById(Long id);
}
