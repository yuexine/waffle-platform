package com.waffle.oauth.service;

import com.waffle.oauth.model.ClientDetail;
import com.waffle.oauth.web.model.ClientDescription;

/**
 * @author yuexin
 */
public interface ClientService {

    /**
     * 根据描述器创建一个客户端
     *
     * @param clientDescription
     * @return
     */
    ClientDetail addClient(ClientDescription clientDescription);


}
