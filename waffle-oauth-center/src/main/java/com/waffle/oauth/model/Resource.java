package com.waffle.oauth.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = "resource")
public class Resource extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "removed")
    private Boolean removed;

    @ManyToMany
    @JoinTable(
            name = "resource_client_details",
            joinColumns = {@JoinColumn(name = "resource_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "client_details_id", nullable = false)})
    private Set<ClientDetail> clientDetailsSet;

    //more...
}
