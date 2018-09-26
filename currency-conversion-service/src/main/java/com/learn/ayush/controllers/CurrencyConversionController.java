package com.learn.ayush.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ayush.models.ConversionValue;
import com.learn.ayush.services.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionService conversionService;
	
	@GetMapping(path="currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionValue convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		BigDecimal conversionFactor =conversionService.fetchConversionFactor(from,to);
		BigDecimal convertedValue = conversionFactor.multiply(quantity);
		return new ConversionValue(1L, from, to, conversionFactor,quantity,convertedValue);
	}
	
	@GetMapping(path="currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionValue convertCurrencyViaProxy(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		BigDecimal conversionFactor =conversionService.fetchConversionFactorViaFeignClient(from,to);
		BigDecimal convertedValue = conversionFactor.multiply(quantity);
		return new ConversionValue(1L, from, to, conversionFactor,quantity,convertedValue);
	}
	
}
