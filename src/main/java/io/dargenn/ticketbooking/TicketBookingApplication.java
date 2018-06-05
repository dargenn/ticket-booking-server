package io.dargenn.ticketbooking;

import io.dargenn.ticketbooking.soap.*;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class TicketBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketBookingApplication.class, args);
    }

//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
//    }
//
//    @Bean(name = Bus.DEFAULT_BUS_ID)
//    public SpringBus springBus() {
//        return new SpringBus();
//    }
//
//    @Bean
//    public FlightWebService flightService() {
//        return new FlightWebServiceImpl();
//    }
//
//    @Bean
//    public Endpoint flightEndpoint() {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), flightService());
//        endpoint.publish("/FlightService");
//        return endpoint;
//    }
//
//    @Bean
//    public CityWebService cityService() {
//        return new CityWebServiceImpl();
//    }
//
//    @Bean
//    public Endpoint cityEndpoint() {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), cityService());
//        endpoint.publish("/CityService");
//        return endpoint;
//    }
//
//    @Bean
//    public PassengerWebService passengerWebService() {
//        return new PassengerWebServiceImpl();
//    }
//
//    @Bean
//    public Endpoint passengerEndpoint() {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), passengerWebService());
//        endpoint.publish("/PassengerService");
//        return endpoint;
//    }
//
//    @Bean
//    public TicketWebService ticketWebService() {
//        return new TicketWebServiceImpl();
//    }
//
//    @Bean
//    public Endpoint ticketEndpoint() {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), ticketWebService());
//        endpoint.publish("/TicketService");
//        return endpoint;
//    }
}
