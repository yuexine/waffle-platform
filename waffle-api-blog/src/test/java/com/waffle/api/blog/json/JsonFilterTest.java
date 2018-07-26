package com.waffle.api.blog.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waffle.api.blog.model.Post;
import org.junit.Test;

/**
 * @author yuexin
 * @since 1.0
 */
public class JsonFilterTest {

    @Test
    public void testFilter() throws JsonProcessingException {
        Post post = new Post();
        post.setAuthor("wuyuexin");
        post.setKeywords("key");
        ObjectMapper mapper = new ObjectMapper();
        JacksonJsonFilter filter = new JacksonJsonFilter();
        filter.filter(Post.class, "id", "author");

        mapper.setFilterProvider(filter);
        mapper.addMixIn(Post.class, filter.getClass());
        System.out.println(mapper.writeValueAsString(post));
    }
}
