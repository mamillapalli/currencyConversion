package com.learning.microservices.currencyconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping(path = "currencyconversionusingresttemplate/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion getConversionValueUsingRestTemplate(@PathVariable(name="fromCurrency") String fromCurrency,
                                                 @PathVariable(name="toCurrency") String toCurrency, @PathVariable(name="quantity")BigDecimal quantity)
    {

        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency",fromCurrency);
        uriVariables.put("toCurrency",toCurrency);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currencyexchange/from/{fromCurrency}/to/{toCurrency}", CurrencyConversion.class, uriVariables);
        // return new CurrencyConversion(1100,fromCurrency,toCurrency,quantity,new BigDecimal(100),new BigDecimal(1000),8100);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        currencyConversion.setQuantity(quantity);
        currencyConversion.setConvertedValue(quantity.multiply(currencyConversion.getExchangeValue()));
        return currencyConversion;
    }

    //using Feign client
    @GetMapping(path = "currencyconversion/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion getConversionValue(@PathVariable(name="fromCurrency") String fromCurrency,
                                                 @PathVariable(name="toCurrency") String toCurrency, @PathVariable(name="quantity")BigDecimal quantity)
    {

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchange(fromCurrency, toCurrency);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setConvertedValue(quantity.multiply(currencyConversion.getExchangeValue()));
        return currencyConversion;
    }
}
