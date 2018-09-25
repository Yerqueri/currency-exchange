package com.learn.ayush.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ExchangeValue {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="from_currency")
	private String from;
	@Column(name="to_currency")
	private String to;
	private BigDecimal conversionValue;
	@Transient
	private int port;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionValue = conversionValue;
		this.port = port;
	}
	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
