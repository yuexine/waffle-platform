package com.waffle.oauth.service;

import com.waffle.oauth.model.Client;
import com.waffle.oauth.model.ClientDetail;
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
    ClientDetail addClient(ClientDescription clientDescription);


    /**
     * get Client By Identity key
     *
     * @param clientId
     * @return
     */
    Client getClientById(Long clientId);
}
