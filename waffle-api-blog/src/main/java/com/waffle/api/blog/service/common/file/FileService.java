package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.web.model.FileDescription;

import java.io.IOException;

/**
 * @author yuexin
 */
public interface FileService {

    FileDescription uploadFile(ResolvedFile resolvedFile) throws IOException;
}
