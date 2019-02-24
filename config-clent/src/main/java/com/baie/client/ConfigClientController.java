package com.baie.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ConfigClientController {
    @Value("${test.mo}")
    private String testValue;

    @GetMapping("test")
    public String getTestValue() {
        return testValue;
    }
}
