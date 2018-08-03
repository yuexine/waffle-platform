package com.waffle.api.blog.service.common.file;

import com.aliyun.oss.model.PutObjectResult;
import com.waffle.api.blog.config.ApplicationProperties;
import com.waffle.component.util.aliyun.AliyunOSS;

import java.io.InputStream;

/**
 * @author yuexin
 */
public class AliOssStorageService implements FileStorage {

    private AliyunOSS aliyunOss;

    private ApplicationProperties applicationProperties;

    public AliOssStorageService(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        ApplicationProperties.AliOSSProp aliOSSProp = applicationProperties.getAliOss();
        aliyunOss = new AliyunOSS(aliOSSProp.getEndpoint(), aliOSSProp.getAccessKeyId(), aliOSSProp.getAccessKeySecret());
    }

    @Override
    public StorageFile storeFile(String name, InputStream inputStream) {
        PutObjectResult result = aliyunOss.putStream(applicationProperties.getAliOss().getBucket(), name, inputStream);
        AliYunOssStorageFile storageInfo = new AliYunOssStorageFile();
        return storageInfo;
    }

}
