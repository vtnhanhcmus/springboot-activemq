package com.example.springbootactivemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
@Slf4j
public class DeadLetterQueueListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "ActiveMQ.DLQ")
    public void handleDeadMsgWiki(Message message) throws JMSException {
        log.error("Received dead letter {}", message.toString());
        int redeliveryCount = message.getIntProperty("JMSXDeliveryCount");
        if (redeliveryCount < 3){
            log.warn("retry message {}", message);
            jmsTemplate.convertAndSend("wiki-queue", message);
        }else {
            log.error("fail message {}", message);
        }
    }
}
