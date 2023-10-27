package com.example.springbootactivemq.services.consumers;

import com.example.springbootactivemq.RandomUtils;
import com.example.springbootactivemq.entities.WikiData;
import com.example.springbootactivemq.repositories.WikiDataRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class JmsConsumer {


    private final WikiDataRepository wikiDataRepository;

    @JmsListener(destination = "wiki-queue")
    public void receiveMessage(String message) throws RuntimeException{
        // Handle the received message here
//        String result = RandomUtils.generateRandomNumber();
//        if (result.equals("FAIL")){
//            log.error("process fail msg {}", message);
//            throw new RuntimeException("msg process fail");
//        }
        log.info("Received message: {}", message);
        WikiData wikiData = new Gson().fromJson(message, WikiData.class);
        log.info("gson value map {}", wikiData);
        wikiDataRepository.save(wikiData);
    }
}
