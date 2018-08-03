package com.waffle.api.blog.service.common.file;

import java.io.InputStream;

/**
 * @author yuexin
 */
public interface FileStorage {

    StorageFile storeFile(String name, InputStream inputStream);
}
