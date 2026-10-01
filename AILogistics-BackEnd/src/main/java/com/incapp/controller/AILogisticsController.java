package com.incapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.incapp.service.AILogisticsService;


@RestController
public class AILogisticsController {
	
	@Autowired
	AILogisticsService aiLogisticsService;
	
	
}
