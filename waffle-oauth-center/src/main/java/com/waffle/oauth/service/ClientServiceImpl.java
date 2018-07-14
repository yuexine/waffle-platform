package com.waffle.oauth.service;

import com.waffle.oauth.config.ApplicationProperties;
import com.waffle.oauth.model.*;
import com.waffle.oauth.model.support.GrantTypeName;
import com.waffle.oauth.model.support.ScopeName;
import com.waffle.oauth.repository.*;
import com.waffle.oauth.web.vmodel.ClientDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

/**
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDetailsRepository clientDetailsRepository;

    private final PasswordEncoder passwordEncoder;

    private Generator<String> generator;

    private final ScopeRepository scopeRepository;

    private final GrantTypeRepository grantTypeRepository;

    private final ApplicationProperties applicationProperties;

    private final ClientRepository clientRepository;

    private final ClientUserRepository clientUserRepository;

    private final BaseUserRepository baseUserRepository;

    @Autowired
    public ClientServiceImpl(ClientDetailsRepository clientDetailsRepository, PasswordEncoder passwordEncoder, ScopeRepository scopeRepository, GrantTypeRepository grantTypeRepository, ApplicationProperties applicationProperties, ClientRepository clientRepository, ClientUserRepository clientUserRepository, BaseUserRepository baseUserRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
        this.passwordEncoder = passwordEncoder;
        this.scopeRepository = scopeRepository;
        this.grantTypeRepository = grantTypeRepository;
        this.applicationProperties = applicationProperties;
        this.clientRepository = clientRepository;
        this.clientUserRepository = clientUserRepository;
        this.baseUserRepository = baseUserRepository;
        generator = new UUIDSecretGenerator();
    }


    @Override
    public ClientDetailEntity addClient(ClientDescription clientDescription) {
        ClientDetailEntity clientDetails = clientDescription.build();
        ClientEntity client = createClient(clientDescription.getName());
        clientDetails.setClient(client);
        clientDetails.setAccessTokenValiditySeconds(getAccessTokenValiditySeconds());
        HashSet<ScopeEntity> scopes = scopeRepository.findByNameAndRemovedFalse(ScopeName.READ).map(s -> {
            HashSet<ScopeEntity> set = new HashSet<>(1);
            set.add(s);
            return set;
        }).orElseThrow(IllegalStateException::new);
        clientDetails.setScopes(scopes);
        clientDetails.setAuthorizedGrantTypeNames(grantTypeRepository.findByType(GrantTypeName.CLIENT_CREDENTIALS).map(s -> {
            HashSet<GrantTypeEntity> set = new HashSet<>(1);
            set.add(s);
            return set;
        }).orElseThrow(IllegalStateException::new));
        clientDetails.setRefreshTokenValiditySeconds(getRefreshTokenValiditySeconds());
        String secret = generator.generate();
        log.debug("ClientId {} 's secret is {}", clientDescription.getClientId(), secret);
        clientDetails.setClientSecret(passwordEncoder.encode((secret)));
        return clientDetailsRepository.save(clientDetails);
    }

    private ClientEntity createClient(String name) {
        ClientEntity clientEntity = new ClientEntity();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        ClientUserEntity clientUser = baseUserRepository.findByLoginAndRemovedFalse(userDetails.getUsername()).map(BaseUserEntity::getClientUser).orElseThrow(NullPointerException::new);
        clientEntity.setClientUser(clientUser);
        clientEntity.setName(name);
        return clientRepository.save(clientEntity);
    }

    private Integer getRefreshTokenValiditySeconds() {
        return applicationProperties.getRefreshTokenValiditySeconds();
    }

    private Integer getAccessTokenValiditySeconds() {
        return applicationProperties.getAccessTokenValiditySeconds();
    }

    @Override
    public Optional<ClientEntity> getClientById(Long clientId) {
        return null;
    }
}
