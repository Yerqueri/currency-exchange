package com.learn.ayush.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ayush.Configuration;
import com.learn.ayush.models.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping(path="limits")
	public LimitConfiguration RetrieveLimitConfiguration() {
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
	
	@GetMapping(path="limits-fault-tolerence")
	@HystrixCommand(fallbackMethod="fallbackRetrieveLimitConfigurationWithFaultTolerence")
	public LimitConfiguration RetrieveLimitConfigurationWithFaultTolerence() {
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration fallbackRetrieveLimitConfigurationWithFaultTolerence() {
		return new LimitConfiguration(9, 999);
	}
}
