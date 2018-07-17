package com.waffle.oauth.web.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.model.BaseUserEntity;

import java.io.Serializable;

/**
 * 用户输出对象包装
 *
 * @author yuexin
 */
public class UserWrapper implements Wrapper, Serializable {

    private static final long serialVersionUID = 3516467867331091077L;

    @JsonIgnore
    private BaseUserEntity userEntity;

    private String username;

    public UserWrapper(BaseUserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public void filter(String... names) {

    }

    public String getUsername() {
        return userEntity.getName();
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
