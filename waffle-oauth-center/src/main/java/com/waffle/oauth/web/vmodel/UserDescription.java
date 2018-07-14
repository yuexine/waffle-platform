package com.waffle.oauth.web.vmodel;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuexin
 */
@Data
public class UserDescription implements Serializable {

    @Length(min = 5, max = 50, message = "用户名长度为5到50个字符")
    private String username;

    @Length(min = 5, max = 50, message = "密码长度为5到50个字符")
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String phone;
}
