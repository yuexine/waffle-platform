package com.waffle.oauth.web.resource;

import com.waffle.oauth.model.BaseUserEntity;
import com.waffle.oauth.service.UserService;
import com.waffle.oauth.web.vmodel.UserDescription;
import com.waffle.oauth.web.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户接口
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@RestController
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public UserWrapper register(@RequestBody @Valid UserDescription userDescription, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Oh, No >> {}", bindingResult.getAllErrors());
        }
        BaseUserEntity userEntity = userService.registerUser(userDescription.getUsername(), userDescription.getPassword(), userDescription.getPhone(), userDescription.getEmail());
        return new UserWrapper(userEntity);
    }
}
