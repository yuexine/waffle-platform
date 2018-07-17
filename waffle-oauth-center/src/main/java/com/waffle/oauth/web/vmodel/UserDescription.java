package com.waffle.oauth.web.vmodel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuexin
 */
@Getter
@Setter
public class UserDescription implements Serializable {

    private static final long serialVersionUID = -4695222652797617033L;

    @Length(min = 5, max = 50, message = "用户名长度为5到50个字符")
    private String username;

    @Length(min = 5, max = 50, message = "密码长度为5到50个字符")
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String phone;
}
