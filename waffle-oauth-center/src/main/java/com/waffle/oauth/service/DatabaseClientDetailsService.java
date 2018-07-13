package com.waffle.oauth.service;

import com.waffle.oauth.model.ClientDetail;
import com.waffle.oauth.model.ClientDetailsAdapter;
import com.waffle.oauth.repository.ClientDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import java.util.Optional;

/**
 * @author yuexin
 */
@Slf4j
//@Service
public class DatabaseClientDetailsService implements ClientDetailsService {

    private ClientDetailsRepository clientDetailsRepository;

    public DatabaseClientDetailsService(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        log.debug("load client start, id is {}", clientId);
        Optional<ClientDetail> clientDetailsOptional = clientDetailsRepository.findByClientId(clientId);

        return clientDetailsOptional
                .map(ClientDetailsAdapter::new)
                .orElseThrow(RuntimeException::new);
    }
}
