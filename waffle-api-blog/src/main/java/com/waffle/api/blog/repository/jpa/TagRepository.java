package com.waffle.api.blog.repository.jpa;

import com.waffle.api.blog.model.Tag;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author yuexin
 * @since 1.0
 */
@Repository
public interface TagRepository extends BaseRepository<Tag, Long> {

    /**
     * 按照Tag名字查找
     *
     * @param name
     * @return
     */
    Optional<Tag> findByName(@Param("name") String name);
}
