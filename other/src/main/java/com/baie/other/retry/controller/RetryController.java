package com.baie.other.retry.controller;

import com.baie.other.retry.services.BackendAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8081/retry?simulateRetry=true&simulateretryfallback=false

@RestController
public class RetryController {
    @Autowired
    BackendAdapter backendAdapter;

    @GetMapping("/retry")
    public String retry(@RequestParam(required = false) boolean simulateRetry, @RequestParam(required = false) boolean simulateretryfallback) {
        return backendAdapter.getBackendResponse(simulateRetry, simulateretryfallback);

    }
}
