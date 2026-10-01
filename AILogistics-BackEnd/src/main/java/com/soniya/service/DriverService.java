package com.soniya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniya.entity.Customer;
import com.soniya.entity.Driver;
import com.soniya.repo.CustomerRepo;
import com.soniya.repo.DriverRepo;

@Service
public class DriverService {
	@Autowired
	private DriverRepo driverRepo;
	
	public boolean register(Driver driver) {
		Driver d=driverRepo.findById(driver.getEmail()).orElse(null);	
		if(d==null) {
			driverRepo.save(driver);
			return true;
		}
		return false;
	}

	public Driver findByEmail(String email) {
		return driverRepo.findById(email).orElse(null);
	}

	public boolean setStatus(String status, String email) {
		Driver d=driverRepo.findById(email).orElse(null);	
		if(d!=null) {
			d.setStatus(status);
			driverRepo.save(d);
			return true;
		}
		return false;
	}
}
