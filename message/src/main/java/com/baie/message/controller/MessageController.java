package com.baie.message.controller;

import com.baie.message.producer.KafkaMessageSendService;
import com.baie.message.stream.service.KafkaSteamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
