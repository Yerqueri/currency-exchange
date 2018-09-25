package com.learn.ayush.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ayush.Exceptions.BadRequestException;
import com.learn.ayush.models.ExchangeValue;
import com.learn.ayush.services.ExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeService exchangeService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to){
		ExchangeValue eval =exchangeService.getConversionRates(from,to);
		if(eval==null) {
			throw new BadRequestException("Conversion from "+ from+" to "+ to +" currently not possible");
		}
		eval.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return eval;
	}
}
