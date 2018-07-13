package com.waffle.oauth.model;

import com.waffle.oauth.constant.TableName;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * 资源描述
 *
 * @author yuexin
 * @since 1.0
 */
@Data
@Entity
@Table(name = TableName.RESOURCE)
public class Resource extends BaseModel {

    /**
     * 资源名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 资源访问编号
     */
    @Column(name = "resource_id", nullable = false)
    private String resourceId;

    /**
     * 资源访问的url地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 资源已删除
     */
    @Column(name = "removed")
    private Boolean removed;

    /**
     * 授权的客户端列表
     */
    @ManyToMany
    @JoinTable(
            name = "resource_client_details",
            joinColumns = {@JoinColumn(name = "resource_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "client_details_id", nullable = false)})
    private Set<ClientDetail> clientDetailsSet;

    //more...
}
