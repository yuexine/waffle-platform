package com.waffle.oauth.web.vmodel;

import com.waffle.oauth.model.ClientDetailEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuexin
 */
@Slf4j
@Data
public class ClientDescription {

    private String clientId;

    public ClientDetailEntity build() {
        ClientDetailEntity clientDetail = new ClientDetailEntity();
        clientDetail.setClientId(clientId);
        return clientDetail;
    }
}
