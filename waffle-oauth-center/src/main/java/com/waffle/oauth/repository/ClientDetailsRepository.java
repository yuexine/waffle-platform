package com.waffle.oauth.repository;

import com.waffle.oauth.model.ClientDetailEntity;

import java.util.Optional;

/**
 * @author yuexin
 */
public interface ClientDetailsRepository extends BaseRepository<ClientDetailEntity, Long> {

    /**
     * 通过 client id 获取 client detail
     *
     * @param clientId
     * @return
     * @since 1.0
     */
    Optional<ClientDetailEntity> findByClientId(String clientId);
}
