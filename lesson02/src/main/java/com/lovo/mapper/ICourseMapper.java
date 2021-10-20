package com.lovo.mapper;

import com.lovo.bean.CourseBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseMapper extends JpaRepository<CourseBean, Long> {

}
