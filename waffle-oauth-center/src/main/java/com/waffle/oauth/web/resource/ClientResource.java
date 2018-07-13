package com.waffle.oauth.web.resource;

import com.waffle.oauth.service.ClientService;
import com.waffle.oauth.web.model.ClientDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexin
 */
@RestController
public class ClientResource extends BaseResource{

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "client")
    public Object postClient(ClientDescription clientDescription) {
//        return clientService.addClient(clientDescription);
        return "OKK";
    }

    @GetMapping(path = "welcome")
    public String welcome() {
        return "Welcome!";
    }

}
