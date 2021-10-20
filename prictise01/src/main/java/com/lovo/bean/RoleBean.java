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
 * 角色类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_role")
public class RoleBean {
    @Id
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
    @Column(name = "pk_id")
    private Long id;
    @Column(name = "r_name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role"
            , joinColumns = @JoinColumn(name = "fk_roleId")
            , inverseJoinColumns = @JoinColumn(name = "fk_userId"))
    @JsonIgnoreProperties({"roleBeans"})
    private List<UserBean> userBeans = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority"
            , joinColumns = @JoinColumn(name = "fk_roleId")
            , inverseJoinColumns = @JoinColumn(name = "fk_authority"))
    @JsonIgnoreProperties({"userBeans"})
    private List<AuthorityBean> authorityBeans = new ArrayList<>();
}
