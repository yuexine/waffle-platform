package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.web.model.PostSearch;
import com.waffle.api.blog.web.wrapper.PostWrapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author yuexin
 */
public interface PostService {

    Optional<Post> findPostById(Long postId);

    Page<Post> searchPostByCondition(PostSearch postCondition);

    Optional<Post> addPost(Post post);

    Optional<Post> publishPost(Long... postId);

    Optional<Post> unPublishPost(Long... postId);

    List<PostWrapper> findRecommendPost(int count);

    List<PostWrapper> findPopularPost(int count);

    List<PostWrapper> findLatestPost(int count);
}
