package com.waffle.api.blog.service.common.file;

import com.aliyun.oss.model.PutObjectResult;
import com.waffle.api.blog.config.ApplicationProperties;
import com.waffle.component.util.aliyun.AliYunOssUtil;
import com.waffle.component.util.common.DateFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.DisposableBean;

import java.io.InputStream;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

/**
 * @author yuexin
 */
@Slf4j
public class AliOssStorageService implements FileStorage, DisposableBean {

    private AliYunOssUtil aliyunOssUtil;

    private ApplicationProperties applicationProperties;

    public AliOssStorageService(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        ApplicationProperties.AliOssProp aliOSSProp = applicationProperties.getAliOss();
        aliyunOssUtil = new AliYunOssUtil(aliOSSProp.getEndpoint(), aliOSSProp.getAccessKeyId(), aliOSSProp.getAccessKeySecret());
    }

    @Override
    public StorageFile storeFile(String destName, InputStream inputStream) {
        PutObjectResult result = aliyunOssUtil.putStream(applicationProperties.getAliOss().getBucket(), destName, inputStream);
        return createFile(result.getETag(), destName);
    }

    @Override
    public StorageFile createFile(String tag, String destName) {
        return new AliYunOssStorageFile(tag, true, destName);
    }

    @Override
    public String createDestFileName(String originalFilename) {
        StringBuilder builder = new StringBuilder();
        builder.append(applicationProperties.getAliOss().getPostRootDir()).append("/")
                .append(DateFormatUtil.format(new Date(), DateFormatUtil.MONTH_PATTERN, TimeZone.getDefault())).append("/")
                .append(UUID.randomUUID()).append(".")
                .append(FilenameUtils.getExtension(originalFilename));
        return builder.toString();
    }

    @Override
    public void destroy() throws Exception {
        log.info("AliYun oss client shutdown.");
        aliyunOssUtil.closeOssClient();
    }
}
