package com.waffle.sso.config;

import com.waffle.component.kafka.consumer.KafkaSender;
import com.waffle.sso.support.KafkaListenerComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuexin
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    public KafkaSender kafkaSender() {
        return new KafkaSender();
    }

    @Bean
    public KafkaListenerComponent kafkaListener() {
        return new KafkaListenerComponent();
    }
}
