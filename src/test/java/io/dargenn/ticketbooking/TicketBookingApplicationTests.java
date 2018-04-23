package io.dargenn.ticketbooking;

import io.dargenn.ticketbooking.domain.city.City;
import io.dargenn.ticketbooking.domain.city.CityService;
import io.dargenn.ticketbooking.domain.flight.FlightService;
import io.dargenn.ticketbooking.domain.passenger.PassengerService;
import io.dargenn.ticketbooking.domain.ticket.Ticket;
import io.dargenn.ticketbooking.domain.ticket.TicketService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketBookingApplicationTests {
	@Autowired private CityService cityService;
	@Autowired private PassengerService passengerService;
	@Autowired private FlightService flightService;
	@Autowired private TicketService ticketService;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(cityService);
		Assert.assertNotNull(passengerService);
		Assert.assertNotNull(flightService);
		Assert.assertNotNull(ticketService);
	}

	@Test
	@Ignore
	public void testCitySave() {
		City city = new City();
		city.setName("Bialystok");
		cityService.save(city);
		List<City> cities = cityService.findAll();
		Assert.assertEquals(false, cities.isEmpty());
	}

	@Test
	public void testBialystokExists() {
		City city = cityService.findByName("Białystok");
		Assert.assertNotNull(city);
	}

	@Test
	public void createXml() {
		Ticket ticket = ticketService.findByCode("48234035-4068-4744-bbca-831916a96ae2");
		StringWriter sw = new StringWriter();
		JAXB.marshal(ticket, sw);
		Assert.assertNotNull(sw.toString());
	}

	@Test
	public void createPdf() throws Exception {
		ticketService.getTicketConfirmation("48234035-4068-4744-bbca-831916a96ae2");
	}
}
