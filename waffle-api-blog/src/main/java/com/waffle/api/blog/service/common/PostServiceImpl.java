package com.waffle.api.blog.service.common;

import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.model.Tag;
import com.waffle.api.blog.model.support.PostStatus;
import com.waffle.api.blog.model.support.PostType;
import com.waffle.api.blog.model.support.SourceType;
import com.waffle.api.blog.repository.jpa.PostRepository;
import com.waffle.api.blog.repository.jpa.TagRepository;
import com.waffle.api.blog.web.model.PostSearch;
import com.waffle.api.blog.web.wrapper.PostWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yuexin
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final TagRepository tagRepository;

    public PostServiceImpl(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public Optional<Post> findPostById(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Page<Post> searchPostByCondition(PostSearch postCondition) {

        return null;
    }

    @Override
    public Optional<Post> addPost(Post post) {
        post.setUser(null);

        post.setSourceType(SourceType.ORIGINAL);
        post.setStatus(PostStatus.PUBLISHED);
        post.setPostType(PostType.PDF);

        post.setTags(postProcessDefaultTags(post.getTags()));

        post = postRepository.save(post);
        log.info("new post id is:{}", post.getId());
        return Optional.of(post);
    }

    @Override
    public Optional<Post> publishPost(Long... postId) {
        return Optional.empty();
    }

    @Override
    public Optional<Post> unPublishPost(Long... postId) {
        return Optional.empty();
    }

    @Override
    public List<PostWrapper> findRecommendPost(int count) {
        return null;
    }

    @Override
    public List<PostWrapper> findPopularPost(int count) {
        return null;
    }

    @Override
    public List<PostWrapper> findLatestPost(int count) {
        return null;
    }

    private Set<Tag> postProcessDefaultTags(Set<Tag> tags) {
        return tags.stream().map(tag -> {
            Optional<Tag> optionalTag = tagRepository.findByName(tag.getName());
            return optionalTag.orElseGet(() -> tagRepository.save(new Tag(tag.getName())));
        }).collect(Collectors.toSet());
    }

}
