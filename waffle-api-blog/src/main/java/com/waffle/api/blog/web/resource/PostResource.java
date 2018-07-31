package com.waffle.api.blog.web.resource;

import com.waffle.api.blog.model.Post;
import com.waffle.api.blog.service.common.PostService;
import com.waffle.api.blog.web.model.PostSearch;
import com.waffle.api.blog.web.wrapper.PostIndex;
import com.waffle.api.blog.web.wrapper.PostWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * POST 接口
 *
 * @author yuexin
 */
@Slf4j
@RestController
public class PostResource {

    private final PostService postService;

    @Autowired
    public PostResource(PostService postService) {
        this.postService = postService;
    }

    /**
     * 根据条件查询 POST 列表
     *
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @GetMapping(path = "post/search")
    public Page<PostWrapper> getPostByCondition(@RequestParam(required = false) String keywords,
                                                @RequestParam(defaultValue = "1") String page,
                                                @RequestParam(defaultValue = "10") String size) {
        PostSearch postSearch = PostSearch.keywords(keywords)
                .page(page)
                .size(size).build();
        Page<Post> posts = postService.searchPostByCondition(postSearch);
        Page<PostWrapper> postWrapper = posts.map(this::wrapperPost);
        return postWrapper;
    }

    /**
     * 根据 ID 查询 POST 详细
     *
     * @param postId
     * @return
     */
    @GetMapping(path = "post/{postId}")
    public PostWrapper getPostById(@PathVariable Long postId) throws Exception {
        Optional<Post> post = postService.findPostById(postId);
        return post.map(this::wrapperPost).orElseThrow(NullPointerException::new);
    }

    /**
     * 获取首页内容
     *
     * @return
     */
    @GetMapping(path = "index")
    public PostIndex getIndex() {
        List<PostWrapper> recommend = postService.findRecommendPost(2);
        List<PostWrapper> popular = postService.findPopularPost(3);
        List<PostWrapper> latest = postService.findLatestPost(3);
        return new PostIndex(recommend, popular, latest);
    }

    private PostWrapper wrapperPost(Post post) {
        return new PostWrapper(post);
    }

}
