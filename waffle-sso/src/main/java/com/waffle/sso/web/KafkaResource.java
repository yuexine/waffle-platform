package com.waffle.sso.web;

import com.waffle.component.kafka.beans.KafkaMessage;
import com.waffle.component.kafka.consumer.KafkaSender;
import com.waffle.sso.models.LogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class KafkaResource {

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("/m/{message}")
    public String sendMessage(@PathVariable String message) {
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage(message);
        kafkaSender.send("log", logMessage);
        return "send:" + message;
    }
}
