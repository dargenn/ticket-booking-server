package io.dargenn.ticketbooking.domain.ticket;

public interface TicketService {
    Ticket findByCode(String code);

    byte[] getTicketConfirmation(String code) throws Exception;
}
