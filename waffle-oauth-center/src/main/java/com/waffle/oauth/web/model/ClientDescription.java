package com.waffle.oauth.web.model;

import com.waffle.oauth.model.ClientDetail;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuexin
 */
@Slf4j
@Data
public class ClientDescription {

    private String clientId;

    public ClientDetail build() {
        ClientDetail clientDetail = new ClientDetail();
        clientDetail.setClientId(clientId);
        return clientDetail;
    }
}
