package com.learn.ayush.models;

public class LimitConfiguration {
	
	private Integer maximum;
	private Integer minimum;
	
	protected LimitConfiguration() {
		super();
	}

	public LimitConfiguration(Integer maximum, Integer minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	
	
}
