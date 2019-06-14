package com.baie.stream.processor;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
public class ProcessorA implements Processor<String, String> {
    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context  = context;
    }

    @Override
    public void process(String key, String value) {
        String lowerCaseValue = value.toLowerCase();
        log.info("Before value: {}, After value {} in ProcessorA.",  value, lowerCaseValue );
        context.forward(key, lowerCaseValue);
    }

    @Override
    public void close() {

    }
}
