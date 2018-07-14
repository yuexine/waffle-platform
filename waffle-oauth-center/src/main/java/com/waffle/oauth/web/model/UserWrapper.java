package com.waffle.oauth.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.model.BaseUserEntity;

import java.io.Serializable;

/**
 * @author yuexin
 */
public class UserWrapper implements Wrapper, Serializable {

    @JsonIgnore
    private BaseUserEntity userEntity;

    public UserWrapper(BaseUserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public void filter(String... names) {

    }
}
