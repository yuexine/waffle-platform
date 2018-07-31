package com.waffle.api.blog.web.resource;

import com.waffle.api.blog.service.common.UserService;
import com.waffle.api.blog.web.model.StandardUserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author yuexin
 */
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * TODO Bean validation
     *
     * @param user
     * @return
     */
    @PostMapping(path = "/user")
    public ResponseEntity registerUser(@RequestBody StandardUserBuilder user) {

        Optional<Long> userId = userService.registerUser(user.build());

        return ResponseEntity.ok(userId.get());
    }

}
