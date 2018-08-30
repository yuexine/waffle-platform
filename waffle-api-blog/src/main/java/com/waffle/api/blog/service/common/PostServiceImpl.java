package com.waffle.api.blog.service.common;

import com.google.common.collect.Lists;
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

import java.util.ArrayList;
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
        //use elastic as default search engine
        return null;
    }

    @Override
    public Optional<Post> addPost(Post post) {
        post.setUser(null);

        post.setSourceType(SourceType.ORIGINAL);
        post.setStatus(PostStatus.PUBLISHED);
        post.setPostType(PostType.PDF);

        post.setTags(postProcessTags(post.getTags()));

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
        PostWrapper postWrapper = new PostWrapper();
        postWrapper.setId(0L);
        postWrapper.setTitle("从2.4万篇文章中挑出的最棒的 JavaScript 学习指南（2018版)");
        postWrapper.setSummary("服务端需要经过socket、bind、accept、read、write等步骤，客户端需要经过socket、connect、read、write等步骤，后续此系列文章会对每一个步骤如何发生进行分析。");
        postWrapper.setKeywords("Webpack 性能 基础概念 函数式编程 面试");
        postWrapper.setImageUrls(Lists.newArrayList("https://user-gold-cdn.xitu.io/2018/1/25/1612d81cbe0eefc0?imageView2/1/w/800/h/600/q/85/format/webp/interlace/1"));
        postWrapper.setContent("");
        postWrapper.setCreatedTime("2018-08-08 12:12:12");
        postWrapper.setUpdatedTime("2018-08-08 12:12:12");

        List<PostWrapper> wrappers = new ArrayList<>();
        wrappers.add(postWrapper);

        return wrappers;
    }

    @Override
    public List<PostWrapper> findPopularPost(int count) {
        return findRecommendPost(0);
    }

    @Override
    public List<PostWrapper> findLatestPost(int count) {
        return findRecommendPost(0);
    }

    private Set<Tag> postProcessTags(Set<Tag> tags) {
        return tags.stream().map(tag -> {
            Optional<Tag> optionalTag = tagRepository.findByName(tag.getName());
            return optionalTag.orElseGet(() -> tagRepository.save(new Tag(tag.getName())));
        }).collect(Collectors.toSet());
    }

}
