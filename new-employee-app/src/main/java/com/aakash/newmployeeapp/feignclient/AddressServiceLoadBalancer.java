package com.aakash.newmployeeapp.feignclient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "ADDRESS-SERVICE" ,configuration = MyCustomLoadBalancerConfig.class)
public class AddressServiceLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feiBuilder(){
        return Feign.builder();
    }
}
