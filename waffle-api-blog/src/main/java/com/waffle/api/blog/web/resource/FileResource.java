package com.waffle.api.blog.web.resource;

import com.waffle.api.blog.service.common.FileService;
import com.waffle.api.blog.service.common.MultipartFileResolver;
import com.waffle.api.blog.web.model.DefaultFileDescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yuexin
 */
@RestController
public class FileResource {

    private FileService fileService;

    @PostMapping
    public ResponseEntity postFile(@RequestParam MultipartFile file) {
        DefaultFileDescription fd = fileService.uploadFile(MultipartFileResolver.resolveMutipartFile(file));
        return ResponseEntity.ok(fd);
    }
}
