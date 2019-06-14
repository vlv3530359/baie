package com.baie.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
@RefreshScope
public class KafkaMessageSendService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic.vlv}")
    private String topic;

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(success->log.info("Send successfully with message: " + message),
                           fail->log.error("Send failed with message: " + message));
    }

}
