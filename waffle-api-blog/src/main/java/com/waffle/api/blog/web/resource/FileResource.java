package com.waffle.api.blog.web.resource;

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

    @PostMapping
    public ResponseEntity postFile(@RequestParam MultipartFile file) {

    }
}
