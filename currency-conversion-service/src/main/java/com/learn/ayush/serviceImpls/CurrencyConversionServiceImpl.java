package com.learn.ayush.serviceImpls;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.ayush.exceptions.ResourceNotFoundException;
import com.learn.ayush.models.ExchangeValue;
import com.learn.ayush.services.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService{

	@Override
	public BigDecimal fetchConversionFactor(String from, String to) {
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

}
