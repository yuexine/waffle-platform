package com.waffle.oauth.repository;

import com.waffle.oauth.model.RoleEntity;
import com.waffle.oauth.model.support.RoleName;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author yuexin
 * @since 1.0
 */
public interface RoleRepository extends BaseRepository<RoleEntity, Long> {

    /**
     * 按照role name查找
     *
     * @param name role name
     * @return role model
     */
    Optional<RoleEntity> findByNameAndRemovedFalse(@Param("name") RoleName name);
}
