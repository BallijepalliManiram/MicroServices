package com.vensai.springboot.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vensai.springboot.limitservice.model.LimitValue;

@RestController
public class LimitController {

	@Autowired
	private LimitValue limitValue;
	
	@GetMapping("/limits")
	public LimitValue getLimits() {
		return new LimitValue(limitValue.getMaximum(),limitValue.getMinimum());
	}
}
