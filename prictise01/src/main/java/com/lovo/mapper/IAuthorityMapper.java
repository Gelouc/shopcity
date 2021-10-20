package com.lovo.mapper;

import com.lovo.bean.AuthorityBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorityMapper extends JpaRepository<AuthorityBean,Long> {
}
