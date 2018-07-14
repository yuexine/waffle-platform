package com.waffle.oauth.web.vmodel;

import com.waffle.oauth.model.ClientDetailEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

/**
 * @author yuexin
 */
@Slf4j
@Data
public class ClientDescription {

    @Length(min = 6, max = 60)
    private String clientId;

    private String name;

    public ClientDetailEntity build() {
        ClientDetailEntity clientDetail = new ClientDetailEntity();
        clientDetail.setClientId(clientId);
        return clientDetail;
    }
}
