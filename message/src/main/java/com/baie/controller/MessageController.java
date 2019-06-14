package com.baie.controller;

import com.baie.core.utils.JsonUtils;
import com.baie.producer.KafkaMessageSendService;
import com.baie.stream.service.KafkaSteamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baie.core.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping("/kafka")
public class MessageController {

    @Autowired
    private KafkaMessageSendService kafkaMessageSendService;

    @Autowired
    private KafkaSteamService kafkaSteamService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
        String message = request.getParameter("message");
        kafkaMessageSendService.sendMessage(message);
        return "发送kafka成功: " + message;
    }

    @RequestMapping(value = "/sendproduct", method = RequestMethod.POST)
    public String sendMessageForProduct(@RequestBody Product product) throws JsonProcessingException {
        kafkaMessageSendService.sendMessage(JsonUtils.objToJson(product));
        return "发送kafka成功: " + product;
    }

    @RequestMapping(value="/stream/start", method = RequestMethod.GET)
    public String streamStart() {
        kafkaSteamService.start();
        return "启动 kafka stream 成功.";
    }

    @RequestMapping(value="/stream/stop", method = RequestMethod.GET)
    public String streamClose() {
        kafkaSteamService.close();
        return "停止 kafka stream 成功.";
    }

    @RequestMapping(value="/batchsend", method = RequestMethod.POST)
    public String batchSend() throws InterruptedException {
        int i = 0;
        while (i < 10) {
            kafkaMessageSendService.sendMessage("MESSAGE" + i);
            Thread.sleep(1000);
            i ++;
        }
        Thread.sleep(5000);
        return "批量发送 message 完成";
    }

}
