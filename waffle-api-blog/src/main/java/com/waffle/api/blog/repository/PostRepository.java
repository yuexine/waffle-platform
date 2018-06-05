package com.waffle.api.blog.repository;

import com.waffle.api.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuexin
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostById(Long id);
}
