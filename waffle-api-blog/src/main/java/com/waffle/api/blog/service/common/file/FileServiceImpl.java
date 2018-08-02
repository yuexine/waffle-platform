package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.Document;
import com.waffle.api.blog.repository.jpa.FileMetaInfoRepository;
import com.waffle.api.blog.web.model.DefaultFileDescription;
import com.waffle.api.blog.web.model.FileDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author yuexin
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileStorage fileStorage;

    @Autowired
    private FileMetaInfoRepository fileMetaInfoRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public FileDescription uploadFile(ResolvedFile resolvedFile) throws IOException {
        FileStorageInfo fileStorageInfo = fileStorage.storeFile(resolvedFile);
        Document document = resolvedFile.getFileMetaInfo(fileStorageInfo.getPath());
        fileMetaInfoRepository.save(document);
        return new DefaultFileDescription(fileStorageInfo, document);
    }
}
