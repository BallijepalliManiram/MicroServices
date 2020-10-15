package com.vensai.springboot.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vensai.springboot.limitsservice.domain.DataLimit;

@RestController
public class LimitsController {

	@Autowired
	private DataLimit dataLimit;
	
	@GetMapping("/limits")
	public DataLimit getLimits() {
		return new DataLimit(dataLimit.getMax(), dataLimit.getMin());
	}
}
