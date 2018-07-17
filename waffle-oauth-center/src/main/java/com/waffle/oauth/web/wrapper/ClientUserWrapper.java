package com.waffle.oauth.web.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.model.ClientUserEntity;

import java.io.Serializable;

/**
 * 客户端用户包装输出类
 *
 * @author yuexin
 * @since 1.0
 */
public class ClientUserWrapper extends UserWrapper implements Wrapper, Serializable {

    private static final long serialVersionUID = -1462966542498589120L;

    @JsonIgnore
    private ClientUserEntity clientUserEntity;

    public ClientUserWrapper(ClientUserEntity clientUserEntity) {
        super(clientUserEntity.getUser());
        this.clientUserEntity = clientUserEntity;
    }

    @Override
    public void filter(String... names) {

    }

}
