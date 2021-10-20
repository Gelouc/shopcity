package com.lovo.controller;

import com.lovo.mapper.IStudentMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class IndexController {
    @Resource
    private IStudentMapper mapper;

    @RequestMapping("index")
    public void index(Model model) {

    }
}
