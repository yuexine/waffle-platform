package com.waffle.sso.service;

import com.waffle.component.kafka.beans.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author yuexin
 */
@Component
public class MessageService {

    @KafkaListener(topics = {"log"})
    public void printMessage(KafkaMessage message) {
        System.out.println("======kafka message start========");
        System.out.println(message);
        System.out.println("======kafka message end========");
    }
}
