package com.lovo.mapper;

import com.lovo.bean.StudentBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IStudentMapper extends JpaRepository<StudentBean, Long>, JpaSpecificationExecutor<StudentBean> {
    List findByNameAndAge(String name, int age);

    @Query("from StudentBean s where s.name = ?1")
    List findCondition(String name);

    @Modifying
    @Query("update StudentBean set age = ?2 where id = ?1")
    void updateAge(Long id, Integer age);

    Page<StudentBean> findByGender(String gender, Pageable val);
}
