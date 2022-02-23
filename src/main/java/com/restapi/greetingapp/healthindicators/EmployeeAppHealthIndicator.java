package com.restapi.greetingapp.healthindicators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.Socket;

@Component
public class EmployeeAppHealthIndicator implements HealthIndicator {
    @Value("${employeeApp.url}")
    private String employeeHealthURL;
    @Autowired
    @Qualifier("appRestClient")
    private RestTemplate restTemplate;
    @Override
    public Health health() {
        // check if url shortener service url is reachable
        try (Socket socket =
                     new Socket(new java.net.URL(employeeHealthURL).getHost(),8080)) {
        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", "Employee App is down")
                    .build();
        }
        return Health.up().build();
    }
}
