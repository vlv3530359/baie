package com.baie.other.asynccontroller;

import com.baie.other.exception.CustomizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/async")
public class HelloWorldCallableController {

    @GetMapping(value = "/testCallable")
    public Callable<String> echoHelloWorld() {
        return () -> {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            return "Hello World !!";
        };
    }
}
