package com.lovo.controller;

import com.lovo.result.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Controller
@Api("上传文件的控制器")
public class IndexController {
    @ResponseResult
    @ResponseBody
    @PostMapping("/upload")
    public Object upload(@RequestParam(value = "file", required = false) MultipartFile file){
        String path = "d:/BaiduYunDownload";
        // 获取上传图片的文件名
        String fileName = file.getOriginalFilename();
        // 截取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 生成新的文件名（时间 + 随机数 + 后缀名）
        String newFileName = new Date().getTime() + "_" + String.valueOf(Math.random()).substring(2) + suffixName;
        File targetFile = new File(path, newFileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFileName;

    }
}
