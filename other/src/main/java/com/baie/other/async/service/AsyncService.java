package com.baie.other.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async("asyncExecutor")
    public CompletableFuture<String> getName() {
        return CompletableFuture.completedFuture("vlv");
    }

    @Async("asyncExecutor")
    public CompletableFuture<String> getPhone() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("12345678898");
    }

    @Async("asyncExecutor")
    public CompletableFuture<String> getLocation() {
        return CompletableFuture.completedFuture("chendu");
    }
}
