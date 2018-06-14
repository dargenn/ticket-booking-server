package io.dargenn.ticketbooking;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TicketBookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketBookingApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);

        return connector;
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
