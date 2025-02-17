package com.aakash.newaddressapp.service;


import com.aakash.newaddressapp.entity.Address;
import com.aakash.newaddressapp.repository.AddressRepository;
import com.aakash.newaddressapp.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;
    public AddressResponse findAddByEmpId(int id){
        Address address= addressRepository.findBuEmployeeId(id);
        AddressResponse addressResponse=modelMapper.map(address,AddressResponse.class);
        return addressResponse;


    }
}
