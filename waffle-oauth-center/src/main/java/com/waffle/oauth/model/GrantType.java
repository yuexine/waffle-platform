package com.waffle.oauth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = "grant_type")
public class GrantType extends BaseModel {

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "removed")
    private Boolean removed;

    @Column(name = "remark", length = 200)
    private String remark;

    @ManyToOne(cascade = CascadeType.ALL)
    private DefaultClientDetails clientDetails;
}
