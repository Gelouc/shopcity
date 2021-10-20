package com.lovo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

public class UploadUtil {

    public static String upload(MultipartFile mf, String dirPath) throws Exception {
        //得到上传文件名
        String fileName = mf.getOriginalFilename();
        //重命名文件
        fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
        //得到上传文件存放目录的真实路径
        URL url = Thread.currentThread().getContextClassLoader()
                .getResources(dirPath).nextElement();
        String filePath = URLDecoder.decode(url.getFile(),"utf-8");
        //将上传文件的二进制数据，写入指定的目录
        mf.transferTo(new File(filePath + "/" + fileName));
        return fileName;
    }
}
