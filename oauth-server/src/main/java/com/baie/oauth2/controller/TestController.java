package com.baie.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/health")
    public String health() {
        return "health";
    }

    @GetMapping("/test")
    public String test() {
        return "need login";
    }

    @PostMapping("/bar")
    public String bar() {
        return "bar";
    }

    @RequestMapping("/hello")
    public String hello() {
        //这边我们,默认是返到templates下的login.html
        return "login";
    }
}
