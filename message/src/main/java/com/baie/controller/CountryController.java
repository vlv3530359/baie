package com.baie.controller;



import com.baie.starter.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Used to test customized springboot starter
 */

@RestController
@Slf4j
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCountry() {
        return countryService.show();
    }

}
