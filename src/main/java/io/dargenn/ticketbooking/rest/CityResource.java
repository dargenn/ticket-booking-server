package io.dargenn.ticketbooking.rest;

import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.city.CityService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityResource {
    private final @NonNull CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> findAll() {

        return cityService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public HttpEntity<City> findById(@PathVariable Long id) {
        City city = cityService.findById(id);
        city.add(linkTo(methodOn(CityResource.class).findAll()).withSelfRel());
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
