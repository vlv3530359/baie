package com.baie.other.sseemiter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://localhost:8080/test/ssemitter
 *
 */
@RestController
@RequestMapping("/emitter")
@Slf4j
public class SseEmiterController {

    @GetMapping("/emitter")
    public ResponseBodyEmitter fetchData() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            try
            {
                int i = 0;
                while (i<20)
                {
                    randomDelay();
                    emitter.send("hello: "+i + " ");
                    i ++;
                }
                emitter.complete();
            }
            catch (IOException e)
            {
                emitter.completeWithError(e);
            }
        });
        executor.shutdown();
        log.info("Async.....");
        return emitter;
    }

    @GetMapping("/ssemitter")
    public ResponseBodyEmitter fetchDataBySseEmitter() {

        SseEmitter emitter = new SseEmitter();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            try
            {
                int i = 0;
                while (i<30)
                {
                    randomDelay();
                    emitter.send("hello world: "+i + " ");
                    i ++;
                }
                emitter.complete();
            }
            catch (IOException e)
            {
                emitter.completeWithError(e);
            }
        });
        executor.shutdown();
        log.info("Async2.....");
        return emitter;
    }

    private void randomDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
