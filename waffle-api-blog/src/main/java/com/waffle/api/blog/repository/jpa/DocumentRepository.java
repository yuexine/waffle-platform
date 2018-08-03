package com.waffle.api.blog.repository.jpa;

import com.waffle.api.blog.model.Document;
import org.springframework.stereotype.Repository;

/**
 * @author yuexin
 */
@Repository
public interface DocumentRepository extends BaseRepository<Document, Long> {
}
