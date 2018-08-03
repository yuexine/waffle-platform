package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.support.DestType;

/**
 * @author yuexin
 */
public interface StorageFile {

    String getKey();

    Boolean saved();

    String getRelativePostion();

    DestType getDestType();
}
