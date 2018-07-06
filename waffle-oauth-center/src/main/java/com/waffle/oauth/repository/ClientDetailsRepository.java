package com.waffle.oauth.repository;

import com.waffle.oauth.model.DefaultClientDetails;
import org.springframework.stereotype.Repository;

/**
 * @author yuexin
 */
@Repository
public interface ClientDetailsRepository extends BaseRepository<DefaultClientDetails, Long> {

}
