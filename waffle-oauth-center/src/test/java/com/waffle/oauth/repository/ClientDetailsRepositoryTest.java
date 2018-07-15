package com.waffle.oauth.repository;

import com.waffle.oauth.model.ClientDetailEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yuexin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientDetailsRepositoryTest {

    @Autowired
    private ClientDetailsRepository clientDetailsRepository;

    @Test
    @Transactional
    public void findByClientId() {
        Optional<ClientDetailEntity> clientDetailEntity = clientDetailsRepository.findByClientId("clientIdtest");
        Assert.assertNotNull(clientDetailEntity);
    }
}