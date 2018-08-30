package com.waffle.api.blog.web.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.api.blog.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
public class PostWrapper implements Wrapper, Ordered, Serializable {

    private static final long serialVersionUID = 3777397660531375246L;

    private Long id;

    private String title;

    private String summary;

    private String keywords;

    private List<String> imageUrls;

    private String content;

    private String createdTime;

    private String updatedTime;

    @JsonIgnore
    private Post post;

    public PostWrapper() {
    }

    public PostWrapper(Post post) {
        this.post = post;
        this.id = post.getId();
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
