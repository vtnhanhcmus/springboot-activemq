package com.example.springbootactivemq.services.listeners;

import com.example.springbootactivemq.entities.WikiDataError;
import com.example.springbootactivemq.repositories.WikiDataErrorRepository;
import com.example.springbootactivemq.repositories.WikiDataRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import java.util.UUID;

@Component
@Slf4j
public class DeadLetterQueueListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private WikiDataErrorRepository wikiDataErrorRepository;

    @JmsListener(destination = "ActiveMQ.DLQ")
    public void handleDeadMsgWiki(String message) throws JMSException {
//        log.error("Received dead letter {}", message.toString());
//        int redeliveryCount = message.getIntProperty("JMSXDeliveryCount");
//        if (redeliveryCount < 3){
//            log.warn("retry message {}", message);
//            jmsTemplate.convertAndSend("wiki-queue", message);
//        }else {
//            log.error("fail message {}", message);
//        }
        log.info("persist message error {}", message);
        WikiDataError wikiDataError = new Gson().fromJson(message, WikiDataError.class);
        wikiDataError.setErrorId(UUID.randomUUID());
        wikiDataErrorRepository.save(wikiDataError);

    }
}
