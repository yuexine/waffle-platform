package com.waffle.oauth.service;

import com.waffle.oauth.model.ResourceEntity;

import java.util.Optional;

/**
 * 资源处理
 *
 * @author yuexin
 * @since 1.0
 */
public interface ResourceService {

    /**
     * 根据资源编号获取资源
     *
     * @param resourceId 资源编号
     * @return 查询结果
     * @since 1.0
     */
    Optional<ResourceEntity> getResourceById(String resourceId);

    /**
     * 新增
     *
     * @param name       资源名
     * @param resourceId 资源key
     * @param url        资源访问地址
     * @return 保存后的 Resource
     * @since 1.0
     */
    ResourceEntity registerResource(String name, String resourceId, String url);

    /**
     * 当前资源是否已被使用
     *
     * @param resourceId resource key
     * @return resource used return true
     */
    boolean resourceIdExists(String resourceId);
}
