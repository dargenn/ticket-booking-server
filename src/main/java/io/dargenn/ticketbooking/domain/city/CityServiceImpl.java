package io.dargenn.ticketbooking.domain.city;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityServiceImpl implements CityService {
    private final @NonNull CityRepository repository;

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public City findById(Long id) {
        return repository.findByCityId(id);
    }
}
