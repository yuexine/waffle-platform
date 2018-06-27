package com.waffle.api.blog.web.resource;

import com.waffle.api.blog.constant.CommonConstant;
import com.waffle.api.blog.service.common.file.FileService;
import com.waffle.api.blog.service.common.file.MultipartFileResolver;
import com.waffle.api.blog.web.model.FileDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yuexin
 */
@RestController
@RequestMapping(CommonConstant.PREFIX)
public class FileResource {

    @Autowired
    private FileService fileService;

    @PostMapping("/resource")
    public ResponseEntity postFile(@RequestParam MultipartFile file) throws IOException {
        FileDescription fd = fileService.uploadFile(MultipartFileResolver.resolveMutipartFile(file));
        return ResponseEntity.ok(fd);
    }
}
