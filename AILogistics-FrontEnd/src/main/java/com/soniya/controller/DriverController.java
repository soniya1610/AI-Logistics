package com.soniya.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soniya.bean.Customer;
import com.soniya.bean.Driver;
import com.soniya.service.AiService;
import com.soniya.service.CustomerService;
import com.soniya.service.DriverService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/driver")
@Controller
public class DriverController {
	@Autowired
	private DriverService driverService;
	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@PostMapping("/register")
	public String register(@ModelAttribute Driver driver, @RequestPart MultipartFile lic,@RequestPart MultipartFile rc ,RedirectAttributes ra) throws IOException {
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		driver.setPassword( bcrypt.encode(driver.getPassword()));
		driver.setVehicle_rc(rc.getBytes());
		driver.setDriving_license(lic.getBytes());
		if(driverService.register(driver)) {
			ra.addFlashAttribute("success", "Driver Registered Successfully but Wait for Admin approval! ");
			return "redirect:/login";
		}else {
			ra.addFlashAttribute("error", "Driver Email Already Exist!");
			return "redirect:/register";
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes ra) {

		Driver driver = driverService.findByEmail(email);
		if (driver == null || !bcrypt.matches(password, driver.getPassword())) {

			ra.addFlashAttribute("error", "Invalid email or password!");
			return "redirect:/login";
		}
		if(driver.getStatus().equalsIgnoreCase("Pending")) {
			ra.addFlashAttribute("error", "Verification Pending!");
			return "redirect:/login";
		}
		if(driver.getStatus().equalsIgnoreCase("Rejected")) {
			ra.addFlashAttribute("error", "Application Rejected!");
			return "redirect:/login";
		}
		if(driver.getStatus().equalsIgnoreCase("Deactivated")) {
			ra.addFlashAttribute("error", "Account Deactivated!");
			return "redirect:/login";
		}
		session.setAttribute("driver", driver);
		return "redirect:/driver/driver-dashboard";
	}
	@GetMapping("/driver-dashboard")
	public String driverDashboard() {
		return "driver/driver-dashboard";
	}
	@GetMapping("/DriverRC")
	public void driverRC(@RequestParam String email, HttpServletResponse response) throws IOException {
		response.getOutputStream().write(driverService.findByEmail(email).getVehicle_rc());
	}
	@GetMapping("/DriverLicense")
	public void driverLicense(@RequestParam String email, HttpServletResponse response) throws IOException {
		response.getOutputStream().write(driverService.findByEmail(email).getDriving_license());
	}
}
