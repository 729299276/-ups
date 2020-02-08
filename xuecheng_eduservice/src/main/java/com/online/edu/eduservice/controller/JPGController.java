package com.online.edu.eduservice.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.online.edu.core.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController

public class JPGController {
    @PostMapping("/upload")
    @ApiOperation(value = "头像上传")
    public R loadJpg(@RequestParam("file") MultipartFile file){

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4FwiUfwfVKGBzuUArvKk";
        String accessKeySecret = "tGlqFEmfnuWsvft0ZYylndKDTGOnvh";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

        try {
            String filename = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            ossClient.putObject("edu-test1", filename, is);
        } catch (Exception e) {
            e.printStackTrace();
        }

// 关闭OSSClient。
        ossClient.shutdown();
        return R.ok().message("上传成功！");
    }
}
