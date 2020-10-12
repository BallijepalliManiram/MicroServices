package com.vensai.springboot.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vensai.springboot.limitsservice.domain.LimitConfiguration;

@RestController
public class LimitController {
	
	@GetMapping("/limits")
	public LimitConfiguration getValuesFromConfiguration() {
		return new LimitConfiguration(1000,1);
	}

}