package com.waffle.oauth.repository;

import com.waffle.oauth.model.ClientDetail;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author yuexin
 */
@Repository
public interface ClientDetailsRepository extends BaseRepository<ClientDetail, Long> {

    Optional<ClientDetail> findByClientId(String clientId);
}
