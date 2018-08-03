package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.Document;
import com.waffle.api.blog.model.support.FileType;
import com.waffle.api.blog.repository.jpa.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yuexin
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private final FileStorage fileStorage;

    private final DocumentRepository documentRepository;

    @Autowired
    public FileServiceImpl(FileStorage fileStorage, DocumentRepository documentRepository) {
        this.fileStorage = fileStorage;
        this.documentRepository = documentRepository;
    }

    @Override
    public Document saveFile(MultipartFile file) throws IOException {
        StorageFile storageFile = fileStorage.storeFile(file.getName(), file.getInputStream());
        if (storageFile.saved()) {
            Document document = buildDocument(file.getOriginalFilename(), file.getSize(), FileType.PDF, storageFile);
            return documentRepository.save(document);
        } else {
            throw new IOException();
        }
    }

    private Document buildDocument(String name, Long size, FileType fileType, StorageFile storageFile) {
        Document document = new Document();
        document.setName(name);
        document.setSize(size);
        document.setType(fileType);
        document.setRelativePosition(storageFile.getRelativePostion());
        document.setDestType(storageFile.getDestType());
        document.setTemporary(true);
        return document;
    }
}
