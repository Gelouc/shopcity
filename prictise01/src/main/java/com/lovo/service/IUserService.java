package com.lovo.service;

import com.lovo.bean.UserBean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public interface IUserService {
    void add(UserBean user);
    Object selectAll(int pageNO);
    UserBean selectById(Long id);
    UserBean selectByName(String name);
}
