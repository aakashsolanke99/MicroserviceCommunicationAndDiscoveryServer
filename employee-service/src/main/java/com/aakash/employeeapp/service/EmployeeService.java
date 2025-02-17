package com.aakash.employeeapp.service;

import com.aakash.employeeapp.entity.Employee;
import com.aakash.employeeapp.repository.EmployeeRepository;
import com.aakash.employeeapp.response.AddressResponse;
import com.aakash.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private WebClient webClient;

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
        addressResponse = callToAddressServiceUsingWebClient(id);



        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    private AddressResponse callToAddressServiceUsingWebClient(int id) {
//
//        List<ServiceInstance> instance = discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance=instance.get(0);

        // application is using load balancer
        ServiceInstance serviceInstance=loadBalancerClient.choose("address-service");
        String uri=serviceInstance.getUri().toString();

        String contextRoot = serviceInstance.getMetadata().get("configPath");

        System.out.println("uri.................>"+uri);
        System.out.println("context path"+contextRoot);

        return webClient
                .get()
                .uri(uri+contextRoot+"/getAddress/" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

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
    }

}
