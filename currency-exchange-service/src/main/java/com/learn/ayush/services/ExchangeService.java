package com.learn.ayush.services;

import com.learn.ayush.models.ExchangeValue;

public interface ExchangeService {

	ExchangeValue getConversionRates(String from, String to);

}
