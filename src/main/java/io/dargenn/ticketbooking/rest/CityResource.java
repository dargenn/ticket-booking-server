package io.dargenn.ticketbooking.rest;

import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.city.CityService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityResource {
    private final @NonNull CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> findAll() {
        return cityService.findAll();
    }
}
