package com.soniya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soniya.entity.Admin;
import com.soniya.entity.Driver;
import com.soniya.repo.AdminRepo;
import com.soniya.repo.DriverRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private DriverRepo driverRepo;
	
	public Admin login(Admin admin) {
		Admin a=adminRepo.findById(admin.getEmail()).orElse(null);
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		if(a!=null && bcrypt.matches(admin.getPassword(), a.getPassword())) {
			return a;
		}else {
			return null;
		}
	}

	public List<Driver> getAllDrivers(String status) {
		if(status.equalsIgnoreCase("All"))
			return driverRepo.findAll();
		else 
			return driverRepo.findAllByStatus(status);
	}
}
