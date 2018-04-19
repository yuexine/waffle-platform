package com.waffle.component.kafka.provider;


import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author yuexin
 */
public interface KafkaReceiver {

    /**
     * listen message callback
     *
     * @param record
     */
    void listen(ConsumerRecord<?, ?> record);
}
