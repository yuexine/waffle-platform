package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.Document;
import com.waffle.api.blog.model.support.FileType;

import java.io.InputStream;

/**
 * @author yuexin
 */
public class ResolvedFile {

    private String fileName;

    private long fileSize;

    private InputStream inputStream;

    private FileType fileType;

    public Document getFileMetaInfo(String path) {
        Document document = new Document();
        document.setSize(getFileSize());
        document.setName(getFileName());
        document.setType(getFileType());
        document.setRelativePosition(path);
        return document;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getFileStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}
