package com.waffle.component.util.aliyun;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author yuexin
 */
public class AliyunOSS {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private OSSClient ossClient;

    public AliyunOSS(String endpoint, String accessKeyId, String accessKeySecret) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        // 创建OSSClient实例。
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    //创建dir1/dir2/dir3/时，已默认为您创建好了dir1/、dir1/dir2/前两级目录。
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
}
