package io.dargenn.ticketbooking.soap;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;

@WebService(endpointInterface = "io.dargenn.ticketbooking.soap.PassengerWebService", targetNamespace = "io.dargenn.ticketbooking")
public class PassengerWebServiceImpl extends SpringBeanAutowiringSupport implements PassengerWebService {
}
