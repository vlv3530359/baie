package com.baie.other.async.controller;

import com.baie.other.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService ayncService;

    @GetMapping("/userInfo")
    public String getUserInfo() throws ExecutionException, InterruptedException {
        CompletableFuture<String> name = ayncService.getName();
        CompletableFuture<String> location = ayncService.getLocation();
        CompletableFuture<String> phone = ayncService.getPhone();
        CompletableFuture.allOf(name, location, phone).join();
        return name.get() + " " + location.get() + " " + phone.get();
    }
}
