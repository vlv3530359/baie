package com.baie.message.stream.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.stereotype.Component;

@Slf4j
public class ProcessorB implements Processor<String, String> {
    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context  = context;
    }

    @Override
    public void process(String key, String value) {
        String firstLetter = value.substring(0,1);
        String UpperCaseFirstLetter = value.replaceFirst(value.substring(0,1), firstLetter.toUpperCase());
        log.info("Before value: {}, After value {} in ProcessorB.",  value, UpperCaseFirstLetter );
        context.forward(key, UpperCaseFirstLetter);
    }

    @Override
    public void close() {

    }
}
