package com.waffle.sso.support;

import com.waffle.component.kafka.beans.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author yuexin
 */
public class KafkaListenerComponent {

    @KafkaListener(topics = {"log"})
    public void printMessage(KafkaMessage message) {
        System.out.println("======kafka message start========");
        System.out.println(message);
        System.out.println("======kafka message end========");
    }
}
