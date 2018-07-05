package com.waffle.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author yuexin
 */
@NoRepositoryBean
public interface BaseRepository extends JpaRepository {
}
