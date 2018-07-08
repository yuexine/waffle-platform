package com.waffle.oauth.web.model;

import com.waffle.oauth.model.DefaultClientDetails;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuexin
 */
@Slf4j
@Data
public class ClientDescription {

    private String clientId;

    public DefaultClientDetails build() {
        DefaultClientDetails defaultClientDetails = new DefaultClientDetails();
        defaultClientDetails.setClientId(clientId);
        return defaultClientDetails;
    }
}
