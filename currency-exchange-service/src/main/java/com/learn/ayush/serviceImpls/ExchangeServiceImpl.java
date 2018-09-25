package com.learn.ayush.serviceImpls;

import org.springframework.stereotype.Service;

import com.learn.ayush.models.ExchangeValue;
import com.learn.ayush.services.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	@Override
	public ExchangeValue getConversionRates(String from, String to) {
		return null;
	}

}
