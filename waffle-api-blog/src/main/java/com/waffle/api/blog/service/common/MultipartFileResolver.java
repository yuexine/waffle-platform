package com.waffle.api.blog.service.common;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yuexin
 */
public abstract class MultipartFileResolver {
    public static ResolvedFile resolveMutipartFile(MultipartFile file) {
        return null;
    }
}
