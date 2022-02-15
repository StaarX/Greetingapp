package com.restapi.greetingapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class GreetingController {

    @Autowired
            GreetingService service;
    Logger log= LoggerFactory.getLogger(GreetingController.class);
    @GetMapping("/greet")
    public ResponseEntity greet(@RequestParam(name = "id", defaultValue = "-1")Long id){
       return ResponseEntity.status(HttpStatus.OK).body(service.greetEmployee(id));
    }

}
