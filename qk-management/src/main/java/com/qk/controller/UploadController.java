package com.qk.controller;

import com.qk.common.Result;
import com.qk.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    /**
     * 文件上传
     *
     * @param image
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();
        // 获取文件后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 生成新的文件名
        String newFileName = UUID.randomUUID() + suffixName;

        String url = aliyunOSSOperator.upload(image.getBytes(), newFileName);
        return Result.success(url);
    }
}
