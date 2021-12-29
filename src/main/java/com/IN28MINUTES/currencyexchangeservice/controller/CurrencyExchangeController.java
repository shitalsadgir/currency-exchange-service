package com.IN28MINUTES.currencyexchangeservice.controller;

import com.IN28MINUTES.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
    @GetMapping("/currency-exchange-value/from/{from}/to/{to}")
    public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue= new ExchangeValue(100L,"USD","INR", BigDecimal.valueOf(75));
         exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
         return exchangeValue;

    }
}
