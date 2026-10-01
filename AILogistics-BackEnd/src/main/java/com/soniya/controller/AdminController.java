package com.soniya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soniya.entity.Admin;
import com.soniya.entity.Driver;
import com.soniya.service.AdminService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/login")
	public Admin login(@RequestBody Admin admin) {
		return adminService.login(admin);
	}
	@GetMapping("/getAllDrivers/{status}")
	public List<Driver> getAllDrivers(@PathVariable String status) {
		return adminService.getAllDrivers(status);
	}
		
}
