package com.lovo.service.impl;

import com.lovo.bean.StudentBean;
import com.lovo.mapper.IStudentMapper;
import com.lovo.service.IStudentService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SutdentServiceImpl implements IStudentService {
    @Resource
    private IStudentMapper mapper;

    @Override
    public void add(StudentBean student) {
        mapper.save(student);
    }

    @Override
    public void del(int id) {
        mapper.deleteById(Long.parseLong(id + ""));
    }

    @Override
    public void update(StudentBean student) {
        mapper.save(student);
    }

    @Override
    public List findAll() {
        return mapper.findAll();
    }

    @Override
    public StudentBean findById(Long id) {
        return mapper.findById(id).get();
    }

    @Override
    public List selectDynamic(String type, String value) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList();
                predicateList.add(criteriaBuilder.equal(root.get(type), value));
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return mapper.findAll(specification);
    }
}
