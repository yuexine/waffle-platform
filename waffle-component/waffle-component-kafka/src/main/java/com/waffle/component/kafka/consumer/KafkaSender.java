package com.waffle.component.kafka.consumer;

import com.waffle.component.kafka.beans.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author yuexin
 */
@Slf4j
public class KafkaSender {

    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;


    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, KafkaMessage kafkaMessage) {
//        log.debug("send kafkaMessage to kafka, kafkaMessage is = {}", kafkaMessage);
        kafkaTemplate.send(topic, kafkaMessage);
    }
}
