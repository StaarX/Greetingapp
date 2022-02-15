package com.restapi.greetingapp;

import com.restapi.greetingapp.exceptions.InternalException;
import com.restapi.greetingapp.exceptions.NotFoundException;
import com.restapi.greetingapp.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {

    private RestTemplate restTemplate;
    Logger log= LoggerFactory.getLogger(GreetingController.class);
    @Autowired
    public GreetingService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateErrorHandler())
                .build();
    }

    public String greetEmployee(Long id){
        String url="http://localhost:8080/employee/employee?id="+id;
        Employee emp=restTemplate.getForObject(url, Employee.class);
        if (emp.getId()==-1) throw new InternalException("Could not be found");
        return "Hello "+emp.getName();
    }
}
