package com.soniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soniya.entity.Customer;
import com.soniya.entity.Driver;
import com.soniya.service.DriverService;


@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@PostMapping("/register")
	public boolean register(@RequestBody Driver driver) {
		return driverService.register(driver);
	}
	@GetMapping("/findByEmail/{email}")
	public Driver findByEmail(@PathVariable String email) {
		return driverService.findByEmail(email);
	}
	@PutMapping("/setStatus/{status}/{email}")
	public boolean setStatus(@PathVariable String status,@PathVariable String email) {
		return driverService.setStatus(status,email);
	}
}
