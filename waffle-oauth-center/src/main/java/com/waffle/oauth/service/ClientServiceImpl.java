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
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public ClientDetailEntity addClient(ClientDescription clientDescription) {
        ClientDetailEntity clientDetails = clientDescription.build();
        clientDetails.setAccessTokenValiditySeconds(getAccessTokenValiditySeconds());
        clientDetails.setRefreshTokenValiditySeconds(getRefreshTokenValiditySeconds());
        String secret = generator.generate();
        clientDetails.setClientSecret(passwordEncoder.encode((secret)));
        clientDetails = clientDetailsRepository.save(clientDetails);
        log.debug("ClientId {} 's secret is {}", clientDescription.getClientId(), secret);

        createClient(clientDescription.getName(), clientDetails);
        createScope(clientDetails);
        createAuthorizedGrantType(clientDetails);

        return clientDetails;
    }

    private void createAuthorizedGrantType(ClientDetailEntity clientDetails) {
        GrantTypeEntity grantType = new GrantTypeEntity();
        grantType.setClientDetails(clientDetails);
        grantType.setRemoved(false);
        grantType.setRemark("客户端授权");
        grantType.setType(GrantTypeName.CLIENT_CREDENTIALS);
        grantTypeRepository.save(grantType);
    }

    private void createScope(ClientDetailEntity clientDetails) {
        ScopeEntity scope = new ScopeEntity();
        scope.setAutoApprove(false);
        scope.setClientDetails(clientDetails);
        scope.setName(ScopeName.READ);
        scope.setRemoved(false);
        scopeRepository.save(scope);
    }

    private ClientEntity createClient(String name, ClientDetailEntity clientDetails) {
        ClientEntity clientEntity = new ClientEntity();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientUserEntity clientUser = baseUserRepository.findByLoginAndRemovedFalse(userDetails.getUsername()).map(BaseUserEntity::getClientUser).orElseThrow(NullPointerException::new);
        clientEntity.setClientUser(clientUser);
        clientEntity.setName(name);
        clientEntity.setClientDetail(clientDetails);
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
