package com.learning.microservices.currencyconversion;

import java.math.BigDecimal;

public class CurrencyConversion {

    private long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal quantity;
    private BigDecimal exchangeValue;
    private BigDecimal convertedValue;
    private int port;

    public CurrencyConversion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(BigDecimal exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public CurrencyConversion(long id, String fromCurrency, String toCurrency, BigDecimal quantity, BigDecimal exchangeValue, BigDecimal convertedValue, int port) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.quantity = quantity;
        this.exchangeValue = exchangeValue;
        this.convertedValue = convertedValue;
        this.port = port;
    }
}
