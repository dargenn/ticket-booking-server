package io.dargenn.ticketbooking.rest;

import io.dargenn.ticketbooking.domain.ticket.Ticket;
import io.dargenn.ticketbooking.domain.ticket.TicketService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketResource {
    private final @NonNull TicketService ticketService;

    @GetMapping
    public Ticket findByCode(@RequestParam("code") String code) {
        return ticketService.findByCode(code);
    }

    @GetMapping("/confirmation")
    public byte[] getTicketConfirmation(@RequestParam("code") String code) throws Exception {
        return ticketService.getTicketConfirmation(code);
    }
}
