package com.waffle.component.kafka.beans;

import java.io.Serializable;

/**
 * @author yuexin
 */
public interface KafkaMessage extends Serializable {

    /**
     *
     * @return
     */
    Long getId();

    /**
     *
     * @return
     */
    String getMessage();

    /**
     *
     * @return
     */
    Long getSendTime();
}
