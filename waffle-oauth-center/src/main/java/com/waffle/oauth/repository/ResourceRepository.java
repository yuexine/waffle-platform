package com.waffle.oauth.repository;

import com.waffle.oauth.model.ResourceEntity;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * resource数据交换
 *
 * @author yuexin
 * @since 1.0
 */
public interface ResourceRepository extends BaseRepository<ResourceEntity, Long> {

    /**
     * 通过 resourceId 获取
     *
     * @param resourceId 资源 resourceId != id
     * @return resource 实例
     * @since 1.0
     */
    Optional<ResourceEntity> findByResourceId(@Param("resourceId") String resourceId);

    /**
     * 已经存在resourceId记录行返回true
     *
     * @param resourceId 资源key
     * @return 已经存在返回true
     */
    Boolean existsByResourceId(@Param("resourceId") String resourceId);
}
