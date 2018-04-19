package com.waffle.sso.models;

import com.waffle.component.kafka.beans.KafkaMessage;
import org.springframework.util.ObjectUtils;

/**
 * @author yuexin
 */
public class LogMessage implements KafkaMessage {

    private Long id;

    private String message;

    private Long sendTime;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Long getSendTime() {
        return ObjectUtils.isEmpty(this.sendTime) ? System.currentTimeMillis() : this.sendTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
