package com.waffle.oauth.web.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.oauth.model.ResourceEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * resourceEntity 结果包装输出
 *
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
public class ResourceDetailWrapper implements Wrapper, Serializable {

    private static final long serialVersionUID = 7033204998124789595L;

    @JsonIgnore
    private ResourceEntity resourceEntity;

    private String resourceId;

    public ResourceDetailWrapper() {
    }

    public ResourceDetailWrapper(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    public ResourceEntity getResourceEntity() {
        return resourceEntity;
    }

    public void setResourceEntity(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    public String getResourceId() {
        return resourceEntity.getResourceId();
    }

    @Override
    public void filter(String... names) {

    }
}
