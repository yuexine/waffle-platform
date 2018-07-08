package com.waffle.oauth.model;

import com.waffle.oauth.model.support.GrantTypeName;
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
    private GrantTypeName type;

    @Column(name = "removed")
    private Boolean removed;

    @Column(name = "remark", length = 200)
    private String remark;

    @ManyToOne(cascade = CascadeType.ALL)
    private DefaultClientDetails clientDetails;
}
