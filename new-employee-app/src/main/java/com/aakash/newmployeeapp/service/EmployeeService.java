package com.aakash.newmployeeapp.service;

//import com.aakash.newmployeeapp.feignclient.AddressClient;
import com.aakash.newmployeeapp.feignclient.AddressClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.aakash.newmployeeapp.entity.Employee;
import com.aakash.newmployeeapp.repository.EmployeeRepository;
import com.aakash.newmployeeapp.response.AddressResponse;
import com.aakash.newmployeeapp.response.EmployeeResponse;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;

//    @Autowired
//    private WebClient  webClient;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Value("${addressservice.base.url}")
//    private String addressBaseURL;

    // we are adding @value in constructor beacuse when the service is created it will constructor and that time @value/ addressBaseURL is null
//    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseURL,RestTemplateBuilder builder) {  // to configure base uri created the contructor and build the rest template no need to create ean in config
//       this.restTemplate= builder.rootUri(addressBaseURL).build();
//    }

    public EmployeeResponse getEmployeeById(int id){

        // set data by making rest api call
        AddressResponse addressResponse =new AddressResponse();

        Employee employee =employeeRepository.findById(id).get(); //db call -> 10 min
        EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);

        // REST template
//      addressResponse = callingAddessServiceUsingRESTTemplate(id); //external rest call  -> 15min

        // Web client
//        addressResponse = callToAddressServiceUsingWebClient(id);


        // Feign Client
        addressResponse = addressClient.getAddressByEmployeeId(id).getBody();

        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

//    private AddressResponse callToAddressServiceUsingWebClient(int id) {
//
//        List<ServiceInstance>  instance = discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance=instance.get(0);
//
//        String uri=serviceInstance.getUri().toString();

//        return webClient
//                .get()
//                .uri(uri+"address-app/api/getAddress/" + id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();

        // without discovery service
//        return webClient
//                .get()
//                .uri("/getAddress/" + id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();
//    }

//    private static AddressResponse callingAddessServiceUsingRESTTemplate(int id) {
//        return restTemplate.getForObject("/getAddress/{id}", AddressResponse.class, id);
//    }

}
