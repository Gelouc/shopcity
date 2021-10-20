package com.lovo.mapper;

import com.lovo.bean.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleMapper extends JpaRepository<RoleBean,Long> {
}
