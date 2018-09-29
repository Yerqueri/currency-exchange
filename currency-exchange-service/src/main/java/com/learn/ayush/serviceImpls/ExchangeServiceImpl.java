package com.learn.ayush.serviceImpls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ayush.models.ExchangeValue;
import com.learn.ayush.repositories.CurrencyExchangeRepository;
import com.learn.ayush.services.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeRepository currencyExcRepo;

	@Override
	public ExchangeValue getConversionRates(String from, String to) {
		logger.info("from->{} to->{}",from,to);
		return currencyExcRepo.findByFromAndTo(from, to);
	}

}
