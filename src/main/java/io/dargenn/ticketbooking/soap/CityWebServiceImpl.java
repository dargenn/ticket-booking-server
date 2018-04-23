package io.dargenn.ticketbooking.soap;

import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "io.dargenn.ticketbooking.soap.CityWebService", targetNamespace = "io.dargenn.ticketbooking")
public class CityWebServiceImpl extends SpringBeanAutowiringSupport implements CityWebService {
    @Autowired private CityService cityService;

    @Override
    public List<String> findAll() {
        return cityService.findAll().stream().map(City::getName).collect(Collectors.toList());
    }
}
