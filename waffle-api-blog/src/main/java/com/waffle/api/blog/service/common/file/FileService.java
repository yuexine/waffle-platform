package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yuexin
 */
public interface FileService {

    /**
     * 保存文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    Document saveFile(MultipartFile file) throws IOException;
}
