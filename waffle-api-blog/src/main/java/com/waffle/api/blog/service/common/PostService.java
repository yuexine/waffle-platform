package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.web.model.PostBuilder;
import com.waffle.api.blog.web.model.PostCondition;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author yuexin
 */
public interface PostService {

    Optional<Post> findPostById(Long postId);

    Page<Post> searchPostByCondition(PostCondition postCondition);

    Optional<Post> addPost(PostBuilder postBuilder);

    Optional<Post> publishPost(Long... postId);

    Optional<Post> unPublishPost(Long... postId);
}
