package com.waffle.oauth.repository;

import com.waffle.oauth.model.DefaultClientDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author yuexin
 */
@Repository
public interface ClientDetailsRepository extends BaseRepository<DefaultClientDetails, Long> {

    Optional<DefaultClientDetails> findByClientId(String clientId);
}
