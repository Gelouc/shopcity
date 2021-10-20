package com.lovo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_class")
public class ClassBean {
    @Id
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
    @Column(name = "class_id")
    private Long id;
    @Column(name = "c_name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "classBean")
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @JsonIgnoreProperties({"classBean"})
    private List<StudentBean> studentList;

}
