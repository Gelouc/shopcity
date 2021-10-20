package com.lovo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "t_student")
public class StudentBean {
    @Id
//    //数据库自增长
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    //最大ID+1
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
//    //uu生成法
//    @GenericGenerator(name = "idGenerator",strategy = "uuid")
//    @GeneratedValue(generator = "idGenerator")
    @Column(name = "pk_id")
    private Long id;
//    @NotBlank
    @Column(name = "s_name")
    private String name;
//    @Pattern(regexp = "^[男|女]$")
    @Column(name = "s_gender")
    private String gender;
    @Column(name = "s_age")
    private Integer age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    @JsonIgnoreProperties({"student"})
    private DetailBean detail;
    @ManyToOne()
    @JoinColumn(name = "class_id")
    @JsonIgnoreProperties({"studentList"})
    private ClassBean classBean;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course"
            , joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseBean> courseBeans = new ArrayList<>();

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
