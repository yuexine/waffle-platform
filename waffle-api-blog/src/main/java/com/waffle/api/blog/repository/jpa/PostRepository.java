package com.waffle.api.blog.repository.jpa;

import com.waffle.api.blog.model.Post;
import org.springframework.stereotype.Repository;

/**
 * @author yuexin
 */
@Repository
public interface PostRepository extends BaseRepository<Post, Long> {

}
