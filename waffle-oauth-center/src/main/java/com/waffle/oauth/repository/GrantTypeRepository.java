package com.waffle.oauth.repository;

import com.waffle.oauth.model.GrantTypeEntity;
import com.waffle.oauth.model.support.GrantTypeName;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author yuexin
 */
public interface GrantTypeRepository extends BaseRepository<GrantTypeEntity, Long> {
    /**
     * 按照名称查找
     *
     * @param typeName 授权名
     * @return 查询结果
     */
    Optional<GrantTypeEntity> findByType(@Param("type") GrantTypeName typeName);
}
