package com.baie.consumer;

import com.baie.core.entity.Product;
import com.baie.core.integration.IntegrationAPIService;
import com.baie.core.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaMessageConsumer {
    @Autowired
    IntegrationAPIService integrationAPIService;

    @KafkaListener(topics={"${kafka.topic.vlv}"})
    public void listen(ConsumerRecord<?, ?> record) throws IOException {

        log.info("kafka的values: " + record.value().toString());
        Product product = buildProduct(record.value().toString());
        integrationAPIService.saveProductInSearchEngine(product);
    }

    private Product buildProduct(String value) throws IOException {
        return (Product) JsonUtils.jsonToObj(Product.class, value);
    }
}
