package com.aakash.newmployeeapp.controller;

import com.aakash.newmployeeapp.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.newmployeeapp.response.EmployeeResponse;
import com.aakash.newmployeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    @CircuitBreaker(name="addressmethod",fallbackMethod = "fallBackEmployeeData")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id")  int id){
         EmployeeResponse employeeResponse= employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    public AddressResponse fallBackEmployeeData(Throwable throwable){
        return new AddressResponse();
    }
}
