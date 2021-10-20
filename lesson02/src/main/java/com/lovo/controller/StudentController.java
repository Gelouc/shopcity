package com.lovo.controller;


import com.lovo.bean.StudentBean;
import com.lovo.result.ResponseResult;
import com.lovo.service.IStudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Resource
    private IStudentService studentService;

    @GetMapping("/{id}")
    public Object showById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseResult
    public Object add(@RequestBody StudentBean studentBean) {
        studentService.add(studentBean);
        return "成功";
    }

    @ResponseBody
    @ResponseResult
    @PostMapping("/upload")
    public Object upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        String path = "d:/BaiduYunDownload";
        String name = file.getOriginalFilename();
        String suffixName = name.substring(name.lastIndexOf("."));
        String newName = new Date().getTime() + "_" + String.valueOf(Math.random()).substring(2) + suffixName;
        File targetFile = new File(path, newName);
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newName;
    }
}
