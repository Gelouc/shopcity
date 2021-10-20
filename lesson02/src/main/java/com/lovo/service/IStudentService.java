package com.lovo.service;

import com.lovo.bean.StudentBean;

import java.util.List;

public interface IStudentService {
    void add(StudentBean student);

    void del(int id);

    void update(StudentBean student);

    List findAll();

    StudentBean findById(Long id);

    List selectDynamic(String type, String value);
}
