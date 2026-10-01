package com.soniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soniya.bean.Customer;
import com.soniya.service.AiService;
import com.soniya.service.CustomerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/customer")
@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@PostMapping("/register")
	public String register(@ModelAttribute Customer customer, RedirectAttributes ra) {
		
		customer.setPassword( bcrypt.encode(customer.getPassword()));
		if(customerService.register(customer)) {
			ra.addFlashAttribute("success", "Customer Registered Successfully!");
			return "redirect:/customer/customer-dashboard";
		}else {
			ra.addFlashAttribute("error", "Customer Email Already Exist!");
			return "redirect:/register";
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes ra) {

		Customer customer = customerService.findByEmail(email);
		if (customer == null || !bcrypt.matches(password, customer.getPassword())) {

			ra.addFlashAttribute("error", "Invalid email or password!");
			return "redirect:/login";
		}
		session.setAttribute("customer", customer);
		return "redirect:/customer/customer-dashboard";
	}
	@GetMapping("/google-success")
	public String googleSuccess(OAuth2AuthenticationToken authentication, HttpSession session) {

		String email = authentication.getPrincipal().getAttribute("email");
		String name = authentication.getPrincipal().getAttribute("name");
		Customer customer = customerService.findByEmail(email);

		if (customer == null) {
			customer = new Customer();
			customer.setEmail(email);
			customer.setName(name);

			// Google authenticated the user.
			// No local password is required.
			customer.setPassword(null);

			customerService.register(customer);
		}

		session.setAttribute("customer", customer);
		session.setAttribute("customerEmail", customer.getEmail());
		return "redirect:/customer/customer-dashboard";
	}
	@GetMapping("/customer-dashboard")
	public String customerDashboard() {
		return "customer/customer-dashboard";
	}
}
