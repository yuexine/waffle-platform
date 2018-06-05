package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.model.support.PostStatus;
import com.waffle.api.blog.web.model.PostBuilder;
import com.waffle.api.blog.web.model.PostCondition;

import java.util.List;

/**
 * @author yuexin
 */
public interface PostService {

    Post findPostById(Long postId);

    List<Post> searchPostByCondition(PostCondition postCondition);

    void addPost(PostBuilder postBuilder);

    void updatePostStatus(Long postId, PostStatus postStatus);
}
