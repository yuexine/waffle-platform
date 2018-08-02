package com.waffle.api.blog.model;

import com.waffle.api.blog.constant.CommonConstant;
import com.waffle.api.blog.model.support.PostStatus;
import com.waffle.api.blog.model.support.PostType;
import com.waffle.api.blog.model.support.SourceType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A Post
 *
 * @author yuexin
 */
@Getter
@Setter
@Entity
@Table(name = CommonConstant.PREFIX + "post")
public class Post extends AbstractModel {

    private static final long serialVersionUID = 2071101288394344952L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "context")
    @Type(type = "text")
    private String context;

    @Column
    @Type(type = "text")
    private String keywords;

    @Column(name = "recommend")
    private Boolean recommend;

    @Column(nullable = false, columnDefinition = "int(2) comment 'post 内容格式: Markdown/Pdf/RichText'")
    @Enumerated(EnumType.ORDINAL)
    private PostType postType;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PostStatus status;

    @Column(name = "source_type")
    private SourceType sourceType;

    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = CommonConstant.PREFIX + "post_tag",
            joinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)})
    private Set<Tag> tags = new HashSet<>();
}
