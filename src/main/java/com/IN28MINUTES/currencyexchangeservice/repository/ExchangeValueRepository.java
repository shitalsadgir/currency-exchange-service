package com.IN28MINUTES.currencyexchangeservice.repository;

import com.IN28MINUTES.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
ExchangeValue findByFromAndTo(String from,String to);


}
