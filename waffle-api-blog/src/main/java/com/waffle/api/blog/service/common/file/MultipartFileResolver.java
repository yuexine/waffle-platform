package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.support.FileType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yuexin
 */
public abstract class MultipartFileResolver {
    public static ResolvedFile resolveMutipartFile(MultipartFile file) throws IOException {
        ResolvedFile resolvedFile = new ResolvedFile();
        resolvedFile.setFileName(file.getOriginalFilename());
        resolvedFile.setInputStream(file.getInputStream());
        resolvedFile.setFileSize(file.getInputStream().available());
        //TODO
        resolvedFile.setFileType(FileType.PDF);
        return resolvedFile;
    }
}
