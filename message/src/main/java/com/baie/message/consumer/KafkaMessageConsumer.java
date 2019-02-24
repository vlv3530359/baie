package com.baie.message.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageConsumer {
    @KafkaListener(topics={"${kafka.topic.vlv}"})
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("kafka的values: " + record.value().toString());
    }
}
