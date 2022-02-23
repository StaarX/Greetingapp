package com.restapi.greetingapp.controller;

import com.restapi.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {

    @Autowired
    GreetingService service;
    @GetMapping("/greet")
    public ResponseEntity greet(@RequestParam(name = "id", defaultValue = "-1")Long id){
       return ResponseEntity.status(HttpStatus.OK).body(service.greetEmployee(id));
    }

//    @GetMapping("//greetForEntity")
//    public ResponseEntity greetExchange(@RequestParam(name = "id", defaultValue = "-1")Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(service.greetEmployeeGetExchange(id));
//    }
}
