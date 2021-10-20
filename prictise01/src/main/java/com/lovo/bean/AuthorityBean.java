package com.lovo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_authority")
public class AuthorityBean {
    @Id
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
    @Column(name = "pk_id")
    private Long id;
    @Column(name = "a_name")
    private String name;
    @Column(name = "a_url")
    private String url;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority"
            , joinColumns = @JoinColumn(name = "fk_authority")
            , inverseJoinColumns = @JoinColumn(name = "fk_roleId"))
    @JsonIgnoreProperties({"authorityBeans"})
    private List<UserBean> userBeans = new ArrayList<>();
}
