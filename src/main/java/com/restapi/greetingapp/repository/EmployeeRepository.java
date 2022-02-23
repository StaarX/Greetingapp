package com.restapi.greetingapp.repository;

import com.restapi.greetingapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Value("${getEmployee.url}")
    private String getEmployeeURL;

    @Autowired
    @Qualifier("appRestClient")
    private RestTemplate restTemplate;

    public List<Employee> getEmployee(Long id){
        getEmployeeURL=getEmployeeURL+id;
        return Arrays.asList(restTemplate.getForObject(getEmployeeURL, Employee[].class));
    }
}
