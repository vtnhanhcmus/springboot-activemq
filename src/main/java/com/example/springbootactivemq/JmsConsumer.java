package com.example.springbootactivemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsConsumer {

    @JmsListener(destination = "wiki-queue")
    public void receiveMessage(String message) throws RuntimeException{
        // Handle the received message here
        String result = RandomUtils.generateRandomNumber();
        if (result.equals("FAIL")){
            log.error("process fail msg {}", message);
            throw new RuntimeException("msg process fail");
        }
        System.out.println("Received message: " + message);

    }
}
