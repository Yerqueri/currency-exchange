package com.learn.ayush.serviceImpls;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.ayush.exceptions.ResourceNotFoundException;
import com.learn.ayush.feignProxies.CurrencyExchangeServiceProxy;
import com.learn.ayush.models.ExchangeValue;
import com.learn.ayush.services.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService{
	
	@Autowired
	private CurrencyExchangeServiceProxy feignProxy;

	@Override
	public BigDecimal fetchConversionFactor(String from, String to) {
		//feign problem
		RestTemplate template = new RestTemplate();
		Map<String,String> URIVariables = new HashMap<>();
		URIVariables.put("from", from);
		URIVariables.put("to", to);
		try {
			ResponseEntity<ExchangeValue> exchangeValue=template.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",ExchangeValue.class,URIVariables);
			return exchangeValue.getBody().getConversionValue();
		}catch (Exception e) {
			throw new ResourceNotFoundException("Conversion method from "+from+" to "+to+" not found");
		}
	}

	@Override
	public BigDecimal fetchConversionFactorViaFeignClient(String from, String to) {
		try {
			ExchangeValue exchangeValue = feignProxy.retrieveExchangeValue(from, to);
			return exchangeValue.getConversionValue();
		}catch (Exception e) {
			throw new ResourceNotFoundException("Conversion method from "+from+" to "+to+" not found");
		}
	}

}
