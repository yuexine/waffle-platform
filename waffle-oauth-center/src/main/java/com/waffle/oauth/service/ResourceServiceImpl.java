package com.waffle.oauth.service;

import com.waffle.oauth.exception.ResourceKeyRepeatedException;
import com.waffle.oauth.model.ResourceEntity;
import com.waffle.oauth.repository.ResourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 资源业务实现
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Optional<ResourceEntity> getResourceById(String resourceId) {
        return resourceRepository.findByResourceId(resourceId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized ResourceEntity registerResource(String name, String resourceId, String url) {
        //validate resourceId has used
        if (resourceIdExists(resourceId)) {
            throw new ResourceKeyRepeatedException();
        }
        ResourceEntity resource = new ResourceEntity();
        resource.setName(name);
        resource.setResourceId(resourceId);
        resource.setUrl(url);
        return resourceRepository.save(resource);
    }

    @Override
    public boolean resourceIdExists(String resourceId) {
        return resourceRepository.existsByResourceId(resourceId);
    }
}
