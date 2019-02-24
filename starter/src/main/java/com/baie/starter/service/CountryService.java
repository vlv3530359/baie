package com.baie.starter.service;

import com.baie.starter.CountryProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryService {
   private CountryProperties countryProperties;

    public CountryService(CountryProperties countryProperties) {
        this.countryProperties  = countryProperties;
    }

    public String show() {
        return "Welcome to " + countryProperties.getName() + " that's code is  " + countryProperties.getCode() + " and GPD is " + countryProperties.getGdp();
    }
}
