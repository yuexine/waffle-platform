package com.waffle.oauth.service;

import com.waffle.oauth.model.DefaultClientDetails;
import com.waffle.oauth.repository.ClientDetailsRepository;
import com.waffle.oauth.web.model.ClientDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexin
 */
@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDetailsRepository clientDetailsRepository;

    @Override
    public DefaultClientDetails addClient(ClientDescription clientDescription) {
        DefaultClientDetails clientDetails = clientDescription.build();
        return clientDetailsRepository.save(clientDetails);
    }
}
