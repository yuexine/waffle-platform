package com.waffle.oauth.service;

import com.waffle.oauth.model.ClientDetailEntity;
import com.waffle.oauth.model.ClientEntity;
import com.waffle.oauth.web.model.ClientDescription;

/**
 * @author yuexin
 * @since 1.0
 */
public interface ClientService {

    /**
     * 根据描述器创建一个客户端
     *
     * @param clientDescription
     * @return
     */
    ClientDetailEntity addClient(ClientDescription clientDescription);


    /**
     * get ClientEntity By Identity key
     *
     * @param clientId
     * @return
     */
    ClientEntity getClientById(Long clientId);
}
