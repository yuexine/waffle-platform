package com.waffle.api.blog.service.common.file;

import java.io.InputStream;

/**
 * 文件本地存储
 *
 * @author yuexin
 */
public class LocalStorageService implements FileStorage {

    @Override
    public StorageFile storeFile(String name, InputStream inputStream) {
        return null;
    }

    @Override
    public StorageFile createFile(String key, String destName) {
        return null;
    }

    @Override
    public String createDestFileName(String originalFilename) {
        return null;
    }
}
