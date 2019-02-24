package com.baie.starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="country.starter")
@Getter
@Setter
public class CountryProperties {

    private String code;

    private String name;

    private String gdp;
}
