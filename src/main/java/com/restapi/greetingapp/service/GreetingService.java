package com.restapi.greetingapp.service;

import com.restapi.greetingapp.exceptions.NotFoundException;
import com.restapi.greetingapp.model.Employee;
import com.restapi.greetingapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

@Autowired
EmployeeRepository repo;
    /*

     */
    public String greetEmployee(Long id){
        List<Employee> emp=repo.getEmployee(id);
        if (emp.get(0).getId()==-1) throw new NotFoundException("Could not retrieve employee.");
        return "Hello "+emp.get(0).getName();
    }

//    public String greetEmployeeGetExchange(Long id){
//        String url="http://localhost:8080/employee?id="+id;
//        HttpEntity<Employee[]> requestEntity = new HttpEntity<>(null, null);
//        ResponseEntity<Employee[]> response = restTemplate
//                .exchange(url, HttpMethod.GET,requestEntity,Employee[].class);
//        List<Employee> emp=Arrays.asList(response.getBody());
//        if (emp.get(0).getId()==-1) throw new InternalException("Could not be found");
//        return "Hello "+emp.get(0).getName();
//    }
}
