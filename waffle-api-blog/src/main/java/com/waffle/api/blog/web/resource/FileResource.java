package com.waffle.api.blog.web.resource;

import com.waffle.api.blog.config.ApplicationProperties;
import com.waffle.api.blog.constant.CommonConstant;
import com.waffle.api.blog.model.Document;
import com.waffle.api.blog.service.common.file.FileService;
import com.waffle.api.blog.web.wrapper.FileWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传
 *
 * @author yuexin
 */
@RestController
@RequestMapping(CommonConstant.PREFIX)
public class FileResource {

    private final FileService fileService;

    private final ApplicationProperties applicationProperties;

    @Autowired
    public FileResource(FileService fileService, ApplicationProperties applicationProperties) {
        this.fileService = fileService;
        this.applicationProperties = applicationProperties;
    }

    @PostMapping("/file")
    public FileWrapper uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Document document = fileService.saveFile(file);

        return new FileWrapper(document, applicationProperties);
    }
}
