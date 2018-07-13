package com.waffle.oauth.repository;

import com.waffle.oauth.model.ClientDetail;

import java.util.Optional;

/**
 * @author yuexin
 */
public interface ClientDetailsRepository extends BaseRepository<ClientDetail, Long> {

    /**
     * 通过 client id 获取 client detail
     *
     * @param clientId
     * @return
     * @since 1.0
     */
    Optional<ClientDetail> findByClientId(String clientId);
}
