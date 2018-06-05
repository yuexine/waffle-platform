package com.waffle.api.blog.model;

import com.waffle.api.blog.constant.CommonConstant;
import com.waffle.api.blog.model.support.PostStatus;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuexin
 */
@Data
@Entity
@Table(name = CommonConstant.PREFIX + "posts")
public class Post extends AbstractModel {

    public static final long serialVersionUID = 56783435945L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "context")
    @Type(type = "text")
    private String context;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PostStatus status;

    @Column(name = "link", nullable = true)
    private String link;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = CommonConstant.PREFIX + "posts_tags",
            joinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)})
    private Set<Tag> tags = new HashSet<>();
}
