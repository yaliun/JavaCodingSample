package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@EnableAutoConfiguration
@ComponentScan
public class CustomerDemoApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	
	@Override
	public void run(String... strings) throws Exception {
		customerService.save(new Customer(1,"nobita","Nobi"));
		customerService.save(new Customer(2,"Takeshi","Goda"));
		customerService.save(new Customer(3,"Suneo","Honekawa"));
		
		List<Customer> list = customerService.findAll();
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerDemoApplication.class, args);
	}
}
