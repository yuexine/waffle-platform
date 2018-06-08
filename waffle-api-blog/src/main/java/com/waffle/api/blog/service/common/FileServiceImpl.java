package com.waffle.api.blog.service.common;

import com.waffle.api.blog.web.model.DefaultFileDescription;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yuexin
 */
@Service
public class FileServiceImpl implements FileService {

    private FileStorage fileStorage;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public DefaultFileDescription uploadFile(ResolvedFile resolvedFile) {


        return null;
    }
}
