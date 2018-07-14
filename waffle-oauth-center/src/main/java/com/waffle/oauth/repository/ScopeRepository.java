package com.waffle.oauth.repository;

import com.waffle.oauth.model.ScopeEntity;
import com.waffle.oauth.model.support.ScopeName;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * scope数据库操作类
 *
 * @author yuexin
 * @since 1.0
 */
public interface ScopeRepository extends BaseRepository<ScopeEntity, Long> {
    /**
     * 按照ScopeName查找
     *
     * @param scopeName key
     * @return 查询结果
     */
    Optional<ScopeEntity> findByNameAndRemovedFalse(@Param("name") ScopeName scopeName);
}
