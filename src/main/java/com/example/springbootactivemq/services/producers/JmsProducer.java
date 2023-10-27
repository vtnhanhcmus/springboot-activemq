package com.example.springbootactivemq.services.producers;

import com.example.springbootactivemq.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class JmsProducer implements CommandLineRunner {

    private final JmsTemplate jmsTemplate;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        sendMessage();
    }

    public void sendMessage() throws InterruptedException {

        EventHandler eventHandler = new WikimediaChangesHandler(jmsTemplate);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
    }
}
