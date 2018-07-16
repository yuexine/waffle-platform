package com.waffle.oauth.web.resource;

import com.waffle.oauth.model.ClientUserEntity;
import com.waffle.oauth.service.ClientUserService;
import com.waffle.oauth.web.vmodel.ClientUserDescription;
import com.waffle.oauth.web.wrapper.ClientUserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 客户端端用户接口
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@RestController
public class ClientUserResource extends BaseResource {

    private final ClientUserService clientUserService;

    @Autowired
    public ClientUserResource(ClientUserService clientUserService) {
        this.clientUserService = clientUserService;
    }

    /**
     * 注册客户端用户
     *
     * @param clientUser
     * @return
     */
    @PostMapping("client/user")
    public ClientUserWrapper registerClientUser(@RequestBody @Valid ClientUserDescription clientUser) {
        ClientUserEntity clientUserEntity = clientUserService.registerClientUser(clientUser.getUsername(), clientUser.getEmail(), clientUser.getPassword(), clientUser.getPhone());
        return new ClientUserWrapper(clientUserEntity);
    }
}
