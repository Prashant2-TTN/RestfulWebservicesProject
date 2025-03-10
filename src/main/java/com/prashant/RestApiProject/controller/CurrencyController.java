package com.prashant.RestApiProject.controller;

import com.prashant.RestApiProject.entity.CurrencyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyConfiguration currencyConfiguration;

    @GetMapping("/service-currency")
    public CurrencyConfiguration retrieveDetails(){
        return currencyConfiguration;
    }
}
