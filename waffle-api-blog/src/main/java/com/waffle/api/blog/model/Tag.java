package com.waffle.api.blog.model;

import com.waffle.api.blog.constant.CommonConstant;
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
@Table(name = CommonConstant.PREFIX + "tag")
public class Tag extends AbstractModel {

    public static final long serialVersionUID = 567834353946L;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = CommonConstant.PREFIX + "tags")
    private Set<Post> posts = new HashSet<>();

    public Tag(String name) {
        setName(name.trim());
    }

    public Tag() {
    }
}
