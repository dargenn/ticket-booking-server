package io.dargenn.ticketbooking.soap;

import io.dargenn.ticketbooking.domain.ticket.Ticket;
import io.dargenn.ticketbooking.domain.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebService;

@WebService(endpointInterface = "io.dargenn.ticketbooking.soap.TicketWebService", targetNamespace = "io.dargenn.ticketbooking")
public class TicketWebServiceImpl extends SpringBeanAutowiringSupport implements TicketWebService {
    @Autowired private TicketService ticketService;

    @Override
    public Ticket findByCode(String code) {
        return ticketService.findByCode(code);
    }

    @Override
    public byte[] getTicketConfirmation(String code) throws Exception {
        return ticketService.getTicketConfirmation(code);
    }

}
