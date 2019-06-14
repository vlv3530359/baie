package com.baie;

import com.baie.producer.KafkaMessageSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSendTests {

	@Autowired
    KafkaMessageSendService kafkaMessageSendService;

	@Test
	public void sendMessage() throws InterruptedException {
		int i = 0;
		while (i < 10) {
			kafkaMessageSendService.sendMessage("message" + i);
			Thread.sleep(1000);
			i ++;
		}
		Thread.sleep(5000);
	}

}

