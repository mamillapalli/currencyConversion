package com.learning.microservices.currencyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//when required to talk direct to a specific instance of the micro service
//@FeignClient(url = "http://localhost:8000", name="currency-exchange")
//when contacting the service through eureka
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy{

    @GetMapping(path="/currencyexchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion getCurrencyExchange(@PathVariable (name="fromCurrency") String fromCurrency, @PathVariable (name="toCurrency") String toCurrency);

}
