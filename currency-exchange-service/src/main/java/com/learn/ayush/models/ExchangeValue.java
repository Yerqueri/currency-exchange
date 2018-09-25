package com.learn.ayush.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ExchangeValue {
	
	@Id
	@GeneratedValue
	private Long id;
	private String from_currency;
	private String to_currency;
	private BigDecimal conversionValue;
	@Transient
	private int port;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom_currency() {
		return from_currency;
	}
	public void setFrom_currency(String from_currency) {
		this.from_currency = from_currency;
	}
	public String getTo_currency() {
		return to_currency;
	}
	public void setTo_currency(String to_currency) {
		this.to_currency = to_currency;
	}
	public BigDecimal getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExchangeValue(Long id, String from_currency, String to_currency, BigDecimal conversionValue) {
		super();
		this.id = id;
		this.from_currency = from_currency;
		this.to_currency = to_currency;
		this.conversionValue = conversionValue;
	}

}
