package com.waffle.oauth.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = "redirect_uri")
public class RedirectUri extends BaseTimedModel {

    @Type(type = "text")
    @Column(name = "uri", nullable = false)
    private String uri;

    @Column(name = "removed")
    private Boolean removed;

    @Column(name = "remark", length = 200)
    private String remark;

    @ManyToOne(cascade = CascadeType.ALL)
    private DefaultClientDetails clientDetails;
}
