package com.restapi.greetingapp;

import com.restapi.greetingapp.exceptions.RestTemplateErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class GreetingApplicationConfiguration {

    @Bean(name="appRestClient")
    public RestTemplate getRestClient(){
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateErrorHandler())
                .setConnectTimeout(Duration.ofSeconds(2))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();
    }
}
