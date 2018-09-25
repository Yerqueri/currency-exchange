package com.learn.ayush.serviceImpls;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ayush.models.ExchangeValue;
import com.learn.ayush.repositories.CurrencyExchangeRepository;
import com.learn.ayush.services.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService{
	
	@Autowired
	private CurrencyExchangeRepository currencyExcRepo;

	@Override
	public ExchangeValue getConversionRates(String from, String to) {
		return currencyExcRepo.findByFromAndTo(from, to);
	}

}
