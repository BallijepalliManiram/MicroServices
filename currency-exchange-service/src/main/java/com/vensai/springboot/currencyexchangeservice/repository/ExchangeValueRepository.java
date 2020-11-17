package com.vensai.springboot.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vensai.springboot.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer>{
	
	ExchangeValue findByFromAndTo(String from , String to);

}
