package com.waffle.sso.models;

import com.waffle.component.kafka.beans.KafkaMessage;

/**
 * @author yuexin
 */
public class OtherMessage implements KafkaMessage {

    private Long id;

    private String message;

    private Long sendTime;

    private String value;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OtherMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                ", value='" + value + '\'' +
                '}';
    }
}
