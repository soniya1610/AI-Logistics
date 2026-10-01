package com.soniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soniya.service.AiService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AILogisticsController {
	@Autowired
	private AiService aiService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/login")
	public String login(@RequestParam(required = false) String role) {
		return "login";
	}
	@GetMapping("/register")
	public String register(@RequestParam(required = false) String role) {
		return "register";
	}
	@GetMapping("/book-shipment")
	public String bookShipment() {
		return "book-shipment";
	}
	@GetMapping("/shipments")
	public String shipments() {
		return "shipments";
	}
	@GetMapping("/shipment")
	public String shipment() {
		return "shipment";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("/PredictVehicle")
	public String predictVehicle(@RequestParam String weight,@RequestParam String width,@RequestParam String length,@RequestParam String height, RedirectAttributes ra) {
		String sys_prompt="""
				Act as Logistic Vehicle Assigner.
				You will be provided with weight, height, length and 
				width of the product, 
				you have to suggest the vehicle type.
				Vehicle type must be strictly from Bike, Cargo Auto, Mini Truck, Truck only. 
				Give only vehicle name.
				""";
		String user_prompt="Here is the product dimensions: Weight: "+weight+" , Width: "+width+" , Height: "+height+" and length: "+length;
		String result=aiService.askAi(sys_prompt,user_prompt);
		ra.addFlashAttribute("result",result);
		return "redirect:/";
	}
	
}
