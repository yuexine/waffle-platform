package com.waffle.api.blog.web.wrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuexin
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class PostIndex implements Serializable {

    private static final long serialVersionUID = -4363786870302361935L;

    private List<PostWrapper> recommend;

    private List<PostWrapper> latest;

    private List<PostWrapper> popular;

    public PostIndex(List<PostWrapper> recommend, List<PostWrapper> popular, List<PostWrapper> latest) {
        this.recommend = recommend;
        this.popular = popular;
        this.latest = latest;
    }
}
