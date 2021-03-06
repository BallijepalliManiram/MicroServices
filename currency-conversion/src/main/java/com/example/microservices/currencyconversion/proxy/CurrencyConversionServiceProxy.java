package com.example.microservices.currencyconversion.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservices.currencyconversion.model.CurrencyConversion;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="zull-api")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyConversionServiceProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeValues(@PathVariable("from") String from , @PathVariable("to") String to) ;
}
