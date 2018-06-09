package com.waffle.api.blog.service.common.file;

import com.aliyun.oss.model.PutObjectResult;
import com.waffle.api.blog.config.ApplicationProperties;
import com.waffle.component.util.aliyun.AliyunOSS;

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
    public FileStorageInfo storeFile(ResolvedFile resolvedFile) {
        PutObjectResult result = aliyunOss.putStream(applicationProperties.getAliOss().getBucket(), resolvedFile.getFileName(), resolvedFile.getFileStream());
        DefaultFileStorageInfo storageInfo = new DefaultFileStorageInfo();
        //TODO

        return storageInfo;
    }

}
