package com.waffle.oauth.web.resource;

import com.waffle.oauth.model.ClientDetailEntity;
import com.waffle.oauth.model.ClientEntity;
import com.waffle.oauth.service.ClientService;
import com.waffle.oauth.web.model.ClientDescription;
import com.waffle.oauth.web.model.ClientDetailWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClientEntity ResourceEntity
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@RestController
public class ClientResource extends BaseResource{

    private final ClientService clientService;

    @Autowired
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("client")
    public Object postClient(@RequestBody @Valid ClientDescription clientDescription, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Oh, No >>", bindingResult.getAllErrors());
            return ResponseEntity.badRequest();
        }
        return clientService.addClient(clientDescription);
    }

    @GetMapping("client/{clientId}")
    public ClientDetailWrapper getClient(@PathVariable Long clientId) {
        ClientEntity client = clientService.getClientById(clientId).orElseGet(ClientEntity::new);
        ClientDetailEntity detail = client.getClientDetail();
        return new ClientDetailWrapper(client, detail);
    }

}
