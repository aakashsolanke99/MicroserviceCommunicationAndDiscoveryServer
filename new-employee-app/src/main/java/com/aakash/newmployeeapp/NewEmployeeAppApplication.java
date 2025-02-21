package com.aakash.newmployeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients     // to create a bean
public class NewEmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewEmployeeAppApplication.class, args);
	}

}
