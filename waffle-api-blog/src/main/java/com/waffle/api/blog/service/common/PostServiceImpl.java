package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.model.support.PostStatus;
import com.waffle.api.blog.repository.PostRepository;
import com.waffle.api.blog.web.model.PostBuilder;
import com.waffle.api.blog.web.model.PostCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuexin
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepository.findPostById(postId);
    }

    @Override
    public List<Post> searchPostByCondition(PostCondition postCondition) {
        return null;
    }

    @Override
    public void addPost(PostBuilder postBuilder) {
        Post post = PostBuilder.build();
        post = postRepository.save(post);
        log.info("new post id is:{}", post.getId());
    }

    @Override
    public void updatePostStatus(Long postId, PostStatus postStatus) {

    }
}
