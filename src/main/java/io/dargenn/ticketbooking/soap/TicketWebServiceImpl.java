package io.dargenn.ticketbooking.soap;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;

@WebService(endpointInterface = "io.dargenn.ticketbooking.soap.TicketWebService", targetNamespace = "io.dargenn.ticketbooking")
public class TicketWebServiceImpl extends SpringBeanAutowiringSupport implements TicketWebService {
}
