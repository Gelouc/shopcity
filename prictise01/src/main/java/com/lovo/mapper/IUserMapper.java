package com.lovo.mapper;

import com.lovo.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface IUserMapper extends JpaRepository<UserBean,Long> {
    UserBean findByCodeAndPwd(String code, String pwd);
    @Query("from UserBean where id = ?1")
    UserBean selectById(Long id);
    UserBean selectByName(String name);
}
