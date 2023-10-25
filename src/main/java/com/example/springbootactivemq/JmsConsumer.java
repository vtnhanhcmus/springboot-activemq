package com.example.springbootactivemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    @JmsListener(destination = "wiki-queue")
    public void receiveMessage(String message) {
        // Handle the received message here
        System.out.println("Received message: " + message);
    }
}
