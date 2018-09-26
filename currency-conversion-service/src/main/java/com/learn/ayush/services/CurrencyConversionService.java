package com.learn.ayush.services;

import java.math.BigDecimal;

public interface CurrencyConversionService {

	BigDecimal fetchConversionFactor(String from, String to);

	BigDecimal fetchConversionFactorViaFeignClient(String from, String to);

}
