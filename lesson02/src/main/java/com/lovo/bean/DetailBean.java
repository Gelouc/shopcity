package com.lovo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_detail")
public class DetailBean {
    @Id
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
    @Column(name = "detail_id")
    private Long id;
    @Column(name = "d_tel")
    private String tel;
    @Column(name = "d_address")
    private String address;
    @OneToOne(mappedBy = "detail")
    @JsonIgnoreProperties({"detail"})
    private StudentBean student;

    @Override
    public String toString() {
        return "DetailBean{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
