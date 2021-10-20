package com.lovo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_user")
public class UserBean implements Serializable {
    @Id
    @GenericGenerator(name = "hbincrement", strategy = "increment")
    @GeneratedValue(generator = "hbincrement")
    @Column(name = "pk_id")
    private Long id;
    @Column(name = "u_code")
    private String code;
    @Column(name = "u_pwd")
    private String pwd;
    @Column(name = "u_codeNum")
    private String codeNum;
    @Column(name = "u_imgPath")
    private String imgPath;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role"
            , joinColumns = @JoinColumn(name = "fk_userId")
            , inverseJoinColumns = @JoinColumn(name = "fk_roleId"))
    @JsonIgnoreProperties({"userBeans"})
    private List<RoleBean> roleBeans = new ArrayList<>();


}
