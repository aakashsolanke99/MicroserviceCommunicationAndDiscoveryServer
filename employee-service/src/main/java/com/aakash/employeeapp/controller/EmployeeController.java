package com.aakash.employeeapp.controller;

import com.aakash.employeeapp.entity.Employee;
import com.aakash.employeeapp.repository.EmployeeRepository;
import com.aakash.employeeapp.response.AddressResponse;
import com.aakash.employeeapp.response.EmployeeResponse;
import com.aakash.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id")  int id){
         EmployeeResponse employeeResponse= employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
