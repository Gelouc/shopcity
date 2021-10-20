package com.lovo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_course")
public class CourseBean {
    @Id
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
    @Column(name = "course_id")
    private Long id;
    @Column(name = "c_name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course"
            , joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentBean> studentBeans = new ArrayList();
}
