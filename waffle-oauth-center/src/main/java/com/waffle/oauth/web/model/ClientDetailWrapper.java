package com.waffle.oauth.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.model.ClientDetailEntity;
import com.waffle.oauth.model.ClientEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 对外暴露的客户端信息
 *
 * @author yuexin
 * @since 1.0
 */
@Setter
@Getter
public class ClientDetailWrapper implements Wrapper, Serializable {

    @JsonIgnore
    private ClientEntity client;

    @JsonIgnore
    private ClientDetailEntity clientDetail;

    private String name;

    public ClientDetailWrapper() {
    }

    public ClientDetailWrapper(ClientEntity client, ClientDetailEntity detail) {
        this.client = client;
        this.clientDetail = detail;
    }

    public String getName() {
        return client.getName();
    }

    @Override
    public void filter(String... names) {
        //TODO: 过滤定义的Key
    }
}
