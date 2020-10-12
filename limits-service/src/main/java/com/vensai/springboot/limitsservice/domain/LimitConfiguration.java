package com.vensai.springboot.limitsservice.domain;

public class LimitConfiguration {
	private int maximum;
	private int minimum;

	// no-argument constructor
	protected LimitConfiguration() {
	}

	// generating getters
	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	// genetrating constructor using fields
	public LimitConfiguration(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}
}