package com.learn.ayush.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ayush.Configuration;
import com.learn.ayush.models.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping(path="limits")
	public LimitConfiguration RetrieveLimitConfiguration() {
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
}
