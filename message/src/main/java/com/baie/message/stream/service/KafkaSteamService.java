package com.baie.message.stream.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KafkaStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaSteamService {

    @Autowired
    KafkaStreams kafkaStreams;

    public void start() {
        synchronized (this) {
            if (!kafkaStreams.state().isRunning()) {
                log.info("Start the kafka stream.");
                kafkaStreams.start();
            }
        }
    }

    public void close() {
        kafkaStreams.close();
    }
}
