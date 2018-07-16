package com.waffle.oauth.web.resource;

import com.waffle.oauth.model.ResourceEntity;
import com.waffle.oauth.service.ResourceService;
import com.waffle.oauth.web.vmodel.ResourceDescription;
import com.waffle.oauth.web.wrapper.ResourceDetailWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 资源管理接口
 * 1. 创建新的资源
 * 2. 获取资源描述
 *
 * @author yuexin
 * @since 1.0
 */
@Slf4j
@RestController
public class ResourceManageResource extends BaseResource {

    private final ResourceService resourceService;

    @Autowired
    public ResourceManageResource(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * 资源 key 已经存在
     *
     * @param resourceId 资源key
     * @return 已存在返回true
     */
    @GetMapping("resource/exists/{resourceId}")
    public ResponseEntity<Boolean> resourceIdExists(@PathVariable("resourceId") String resourceId) {
        return ResponseEntity.ok(resourceService.resourceIdExists(resourceId));
    }

    /**
     * 注册一组资源
     *
     * @param rd            resource 描述
     * @param bindingResult 绑定结果
     * @since 1.0
     */
    @PostMapping("resource")
    public ResponseEntity registerResource(@RequestBody @Valid ResourceDescription rd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Oh, No >> {}", bindingResult.getAllErrors());
        }
        ResourceEntity re = resourceService.registerResource(rd.getName(), rd.getResourceId(), rd.getUri());
        return ResponseEntity.ok().body(re.getId());
    }

    /**
     * 获取资源
     *
     * @param resourceId 资源key
     * @return 包装后的resource
     * @since 1.0
     */
    @GetMapping("resource/{resourceId}")
    public ResourceDetailWrapper getResource(@PathVariable String resourceId) {
        ResourceEntity resourceEntity = resourceService.getResourceById(resourceId).orElseGet(ResourceEntity::new);
        return new ResourceDetailWrapper(resourceEntity);
    }


}
