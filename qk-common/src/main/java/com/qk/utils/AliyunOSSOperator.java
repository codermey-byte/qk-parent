package com.qk.utils;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

@Slf4j
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSOperator {

    private String endpoint;
    private String bucketName;
    private String region;

    public String upload(byte[] content, String objectName) throws Exception {
        // 创建OSSClient实例
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = null;
        try {
            ossClient = OSSClientBuilder.create()
                    .endpoint(endpoint)
                    .credentialsProvider(new EnvironmentVariableCredentialsProvider())
                    .clientConfiguration(clientBuilderConfiguration)
                    .region(region)
                    .build();
            // 创建PutObjectRequest对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(content));
            // 上传文件
            ossClient.putObject(putObjectRequest);
            // 返回文件访问URL
            return "https://" + bucketName + "." + endpoint.substring(8) + "/" + objectName;
        } catch (Exception e) {
            log.error("Caught an OSSException: " + e.getMessage());
            throw e;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}