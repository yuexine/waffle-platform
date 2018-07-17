package com.waffle.oauth.web.vmodel;

import com.waffle.oauth.model.ClientDetailEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author yuexin
 */
@Slf4j
@Getter
@Setter
public class ClientDescription implements Serializable {

    private static final long serialVersionUID = 5111736309670732864L;

    @Length(min = 6, max = 60)
    private String clientId;

    private String name;

    public ClientDetailEntity build() {
        ClientDetailEntity clientDetail = new ClientDetailEntity();
        clientDetail.setClientId(clientId);
        return clientDetail;
    }
}
