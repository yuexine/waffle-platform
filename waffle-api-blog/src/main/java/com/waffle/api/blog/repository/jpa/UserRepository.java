package com.waffle.api.blog.repository.jpa;

import com.waffle.api.blog.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author yuexin
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}
