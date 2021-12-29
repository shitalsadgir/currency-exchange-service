package com.IN28MINUTES.currencyexchangeservice.controller;

import com.IN28MINUTES.currencyexchangeservice.bean.ExchangeValue;
import com.IN28MINUTES.currencyexchangeservice.repository.ExchangeValueRepository;
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
    @Autowired
    private ExchangeValueRepository exchangeValueRepository;
    @GetMapping("/currency-exchange-value/from/{from}/to/{to}")
    public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue= exchangeValueRepository.findByFromAndTo(from,to);
         exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
         return exchangeValue;

    }
}
