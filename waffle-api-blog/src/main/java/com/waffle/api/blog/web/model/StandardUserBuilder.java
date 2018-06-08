package com.waffle.api.blog.web.model;

import com.waffle.api.blog.model.User;
import lombok.Data;

/**
 * @author yuexin
 */
@Data
public class StandardUserBuilder {

    private String username;

    private String phone;

    private String email;

    private String password;

    public User build() {
        User u = new User();
        u.setName(getUsername());
        u.setPassword(getPassword());
        u.setEmail(getEmail());
        u.setPhone(getPhone());
        return u;
    }
}
