package com.online;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.online.edu.eduservice.EduApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= EduApp.class)
public class Demotest {
    @Test
    //创建bucket
    public void ossTest(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4FwiUfwfVKGBzuUArvKk";
        String accessKeySecret = "tGlqFEmfnuWsvft0ZYylndKDTGOnvh";
        String bucketName = "edu-test1";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建存储空间。
        ossClient.createBucket(bucketName);

// 关闭OSSClient。
        ossClient.shutdown();
    }
    //上传文件
    @Test
    public void uptesxt(){
// Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4FwiUfwfVKGBzuUArvKk";
        String accessKeySecret = "tGlqFEmfnuWsvft0ZYylndKDTGOnvh";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

// 上传Byte数组。
        byte[] content = "Hello OSS".getBytes();
        ossClient.putObject("edu-test1", "1.txt", new ByteArrayInputStream(content));

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
