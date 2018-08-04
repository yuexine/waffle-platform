package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.support.DestType;

/**
 * @author yuexin
 */
public interface StorageFile {

    String getTag();

    Boolean saved();

    String getRelativePosition();

    DestType getDestType();
}
