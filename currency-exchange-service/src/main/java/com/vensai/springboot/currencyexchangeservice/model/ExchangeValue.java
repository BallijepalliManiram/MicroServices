package com.vensai.springboot.currencyexchangeservice.model;

import java.math.BigDecimal;

public class ExchangeValue {

	private int id;
	private String from;
	private String to;
	private BigDecimal convertionValue;
	private int port;

	public ExchangeValue() {

	}

	public ExchangeValue(int id, String from, String to, BigDecimal convertionValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionValue = convertionValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConvertionValue() {
		return convertionValue;
	}

	public void setConvertionValue(BigDecimal convertionValue) {
		this.convertionValue = convertionValue;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
