package com.baie.other.retry.services;

import com.baie.other.retry.exception.RemoteServiceNotAvailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class BackendAdapterImpl implements BackendAdapter {
    @Override
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) {
        if (simulateretry) {
            log.info("Simulateretry is true, so try to simulate exception scenerio.");
        }
        if (simulateretryfallback) {
            throw new RemoteServiceNotAvailableException(
                    "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
        }
        int random = new Random().nextInt(4);
        log.info("Random Number : " + random);
        if (random % 2 == 0) {
            throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
        }
        return "Hello from Remote Backend!!!";
    }

    @Override
    public String getBackendResponseFallback(RuntimeException e) {
        log.info("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}
