package com.soniya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.soniya.service.AILogisticsService;


@RestController
public class AILogisticsController {
	
	@Autowired
	AILogisticsService aiLogisticsService;
	
	
}
