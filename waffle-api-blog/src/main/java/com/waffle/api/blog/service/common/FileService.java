package com.waffle.api.blog.service.common;

import com.waffle.api.blog.web.model.DefaultFileDescription;

/**
 * @author yuexin
 */
public interface FileService {

    DefaultFileDescription uploadFile(ResolvedFile resolvedFile);
}
