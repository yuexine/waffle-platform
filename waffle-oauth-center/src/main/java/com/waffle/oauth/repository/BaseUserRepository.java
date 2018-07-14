package com.waffle.oauth.repository;

import com.waffle.oauth.model.BaseUserEntity;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author yuexin
 */
public interface BaseUserRepository extends BaseRepository<BaseUserEntity, Long> {

    /**
     * 查找未删除的用户
     *
     * @param login 登录账户
     * @return 查询结果
     */
    Optional<BaseUserEntity> findByLoginAndRemovedFalse(@Param("login") String login);
}
