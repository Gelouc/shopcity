package com.lovo.mapper;

import com.lovo.bean.ClassBean;
import com.lovo.bean.StudentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IClassMapper extends JpaRepository<ClassBean, Long>, JpaSpecificationExecutor<ClassBean> {
}
