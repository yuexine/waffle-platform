package com.waffle.sso.web;

import com.waffle.component.kafka.consumer.KafkaSender;
import com.waffle.sso.models.LogMessage;
import com.waffle.sso.models.OtherMessage;
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

    @GetMapping("/m2/{message}")
    public String sendOtherMessage(@PathVariable String message) {
        OtherMessage otherMessage = new OtherMessage();
        otherMessage.setMessage(message);
        otherMessage.setId(34L);
        otherMessage.setValue("foo");
        otherMessage.setSendTime(System.currentTimeMillis());
        kafkaSender.send("log", otherMessage);
        return "send:" + message;
    }

    @GetMapping("/p/{message}")
    public String put(@PathVariable String message) {
//        hBaseTemplate.put("testtb2", "testrow1", "fam1", "qua1", message.getBytes());
        return message;
    }
}
