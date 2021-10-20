package com.lovo;

import com.lovo.bean.CourseBean;
import com.lovo.bean.DetailBean;
import com.lovo.bean.StudentBean;
import com.lovo.mapper.IClassMapper;
import com.lovo.mapper.ICourseMapper;
import com.lovo.mapper.IStudentMapper;
import com.lovo.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Resource
    private IStudentService service;
    @Resource
    private IStudentMapper mapper;
    @Resource
    private IClassMapper classMapper;
    @Resource
    private ICourseMapper courseMapper;

    @Test
    public void test() {
//        StudentBean s = new StudentBean(null,"小煜","男",36);
//        service.add(s);
//        System.out.println(service.findAll());
//        service.del(13);
//        service.update(new StudentBean(Long.parseLong("4"),"小cc","女",20));
//        System.out.println(service.findById(Long.parseLong("4")));

//        System.out.println(mapper.findCondition("小强"));
//        mapper.updateAge(Long.parseLong("1"),18);
//        System.out.println(mapper.findByNameAndAge("小强", 30));
//        System.out.println(mapper.findByGender("女", PageRequest.of(0,3)).getContent());
//        System.out.println(mapper.findAll(PageRequest.of(1,3)).getContent());
//        service.add(new StudentBean(null,"小陈","男",48,new DetailBean(null,"110","上海",null)));
//        service.del(15);
//        System.out.println(classMapper.findAll());
//        classMapper.deleteById(1L);

//        List courseBeans = new ArrayList();
//        courseBeans.add(new CourseBean(null,"Java基础",null));
//        courseBeans.add(new CourseBean(null,"Java进阶",null));
//        StudentBean studentBean = new StudentBean(null,"诸葛亮","男",30,null,null,courseBeans);
//        service.add(studentBean);

        courseMapper.deleteById(1L);
    }

    @Test
    public void testSelectDynamic() {
        System.out.println(service.selectDynamic("name", "小S"));
    }
}
