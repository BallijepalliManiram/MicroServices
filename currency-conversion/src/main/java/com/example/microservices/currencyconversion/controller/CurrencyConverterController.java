package com.example.microservices.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.currencyconversion.model.CurrencyConversion;
import com.example.microservices.currencyconversion.proxy.CurrencyConversionServiceProxy;

@RestController
public class CurrencyConverterController {

	@Autowired
	private CurrencyConversionServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> urlvariables = new HashMap<>();
		urlvariables.put("from", from);
		urlvariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, urlvariables);
		CurrencyConversion currencyConverter = responseEntity.getBody();
		return new CurrencyConversion(currencyConverter.getId(), from, to, currencyConverter.getConvertionValue(),
				quantity, quantity.multiply(currencyConverter.getConvertionValue()), currencyConverter.getPort());

	}
	
	//By feign
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion currencyConverter = proxy.getExchangeValues(from, to);
		return new CurrencyConversion(currencyConverter.getId(), from, to, currencyConverter.getConvertionValue(),
				quantity, quantity.multiply(currencyConverter.getConvertionValue()), currencyConverter.getPort());

	}
}
