package com.waffle.api.blog.web.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.api.blog.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
public class PostWrapper implements Wrapper, Serializable {

    private static final long serialVersionUID = 3777397660531375246L;

    @JsonIgnore
    private Post post;

    public PostWrapper(Post post) {
        this.post = post;
    }


}
