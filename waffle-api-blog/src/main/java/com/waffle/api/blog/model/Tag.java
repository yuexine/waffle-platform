package com.waffle.api.blog.model;

import com.waffle.api.blog.constant.CommonConstant;
import com.waffle.api.blog.model.support.TagType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * issue:
 * 1. 如何建立tag之间的关系
 *
 * @author yuexin
 */
@Getter
@Setter
@Entity
@Table(name = CommonConstant.PREFIX + "tags")
public class Tag extends AbstractModel {

    public static final long serialVersionUID = 567834353946L;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private TagType type;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = CommonConstant.PREFIX + "tags")
    private Set<Post> posts = new HashSet<>();

}
