package com.waffle.oauth.service;

import com.waffle.oauth.model.ClientDetailEntity;
import com.waffle.oauth.model.ClientEntity;
import com.waffle.oauth.repository.ClientDetailsRepository;
import com.waffle.oauth.web.vmodel.ClientDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDetailEntity addClient(ClientDescription clientDescription) {
        ClientDetailEntity clientDetails = clientDescription.build();
        return clientDetailsRepository.save(clientDetails);
    }

    @Override
    public Optional<ClientEntity> getClientById(Long clientId) {
        return null;
    }
}
