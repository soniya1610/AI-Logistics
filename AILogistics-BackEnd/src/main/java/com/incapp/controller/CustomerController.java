package com.incapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incapp.entity.Customer;
import com.incapp.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register")
	public boolean register(@RequestBody Customer customer) {
		return customerService.register(customer);
	}
	@GetMapping("/findByEmail/{email}")
	public Customer findByEmail(@PathVariable String email) {
		return customerService.findByEmail(email);
	}
	
}
