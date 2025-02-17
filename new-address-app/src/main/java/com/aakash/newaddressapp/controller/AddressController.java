package com.aakash.newaddressapp.controller;


import com.aakash.newaddressapp.entity.Address;
import com.aakash.newaddressapp.repository.AddressRepository;
import com.aakash.newaddressapp.response.AddressResponse;
import com.aakash.newaddressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id){
        AddressResponse addressResponse=addressService.findAddByEmpId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/address/{id}")
    public Address get(@PathVariable int id){
        return addressRepository.findById(id).get();
    }
}
