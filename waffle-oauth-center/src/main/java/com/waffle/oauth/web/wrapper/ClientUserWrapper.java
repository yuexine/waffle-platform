package com.waffle.oauth.web.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.model.ClientUserEntity;

/**
 * 客户端用户包装输出类
 *
 * @author yuexin
 * @since 1.0
 */
public class ClientUserWrapper implements Wrapper {

    @JsonIgnore
    private ClientUserEntity clientUserEntity;

    public ClientUserWrapper(ClientUserEntity clientUserEntity) {
        this.clientUserEntity = clientUserEntity;
    }

    @Override
    public void filter(String... names) {

    }
}
