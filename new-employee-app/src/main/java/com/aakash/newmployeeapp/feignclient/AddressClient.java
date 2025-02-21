package com.aakash.newmployeeapp.feignclient;

import com.aakash.newmployeeapp.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

////@FeignClient(name = "address-service",url = "http://localhost:8081",path = "/address-app/api")
//@FeignClient(name = "address-service",url = "http://localhost:8081",path = "/address-app/api")
// name = "ADDRESS-SERVICE",  --> name of discovery register service
@FeignClient(name = "ADDRESS-SERVICE",path = "/address-app/api/")
public interface AddressClient {  //proxy class

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);
}
