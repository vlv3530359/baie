package com.baie.starter.config;

import com.baie.starter.CountryProperties;
import com.baie.starter.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CountryProperties.class)
@ConditionalOnClass(CountryService.class)
@ConditionalOnProperty(prefix = "country.starter", value="enabled", matchIfMissing = true)
public class CountryAutoConfiguration {

    @Autowired
    private CountryProperties countryProperties;

    @Bean(name="countryService")
    public CountryService buildCountryService() {
        return new CountryService(countryProperties);
    }
}
