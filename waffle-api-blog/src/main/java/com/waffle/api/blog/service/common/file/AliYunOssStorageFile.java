package com.waffle.api.blog.service.common.file;

import com.waffle.api.blog.model.support.DestType;

/**
 * @author yuexin
 */
public class AliYunOssStorageFile implements StorageFile {

    private String key;

    private Boolean saved;

    private String position;

    public AliYunOssStorageFile(String key, Boolean saved, String position) {
        this.key = key;
        this.saved = saved;
        this.position = position;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Boolean saved() {
        return saved;
    }

    @Override
    public String getRelativePosition() {
        return position;
    }

    @Override
    public DestType getDestType() {
        return DestType.ALIYUN_OSS;
    }
}
