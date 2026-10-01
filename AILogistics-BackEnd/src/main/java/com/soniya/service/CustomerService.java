package com.soniya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniya.entity.Customer;
import com.soniya.entity.Driver;
import com.soniya.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	
	public boolean register(Customer customer) {
		Customer c=customerRepo.findById(customer.getEmail()).orElse(null);	
		if(c==null) {
			customerRepo.save(customer);
			return true;
		}
		return false;
	}

	public Customer findByEmail(String email) {
		return customerRepo.findById(email).orElse(null);
	}
}
