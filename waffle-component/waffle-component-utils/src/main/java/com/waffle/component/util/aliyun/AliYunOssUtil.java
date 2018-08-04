package com.waffle.component.util.aliyun;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author yuexin
 */
public class AliYunOssUtil {

    private OSSClient ossClient;

    public AliYunOssUtil(String endpoint, String accessKeyId, String accessKeySecret) {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 创建dir1/dir2/dir3/时，已默认为您创建好了dir1/、dir1/dir2/前两级目录。
     *
     * @param bucket
     * @param suffixWithSlash
     * @return
     */
    public PutObjectResult createDir(String bucket, String suffixWithSlash) {
        return ossClient.putObject(bucket, suffixWithSlash, new ByteArrayInputStream(new byte[0]));
    }

    public PutObjectResult putStream(String bucket, String name, InputStream stream) {
        //name:/abc/d.doc
        return ossClient.putObject(bucket, name, stream);
    }

    public OSSClient getOssClient() {
        return ossClient;
    }

    public void closeOssClient() {
        ossClient.shutdown();
    }
}
