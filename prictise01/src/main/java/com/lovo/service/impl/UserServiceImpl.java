package com.lovo.service.impl;

import com.lovo.bean.UserBean;
import com.lovo.mapper.IUserMapper;
import com.lovo.service.IUserService;
import com.lovo.util.RedisUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserMapper mapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public void add(UserBean user) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
//        String encodePasswod = (String) encoder.encode(user.getPwd());
        user.setPwd(DigestUtils.sha256Hex(user.getPwd()));
        mapper.save(user);
    }

    @Override
    public Object selectAll(int pageNO) {
        Long start = System.currentTimeMillis();
        // 从缓存中获取数据
        Object obj = redisUtil.get("selectAll"+pageNO);
        if(obj == null){
            // 如果缓存中没有数据，从数据库获取，并加入到缓存
            obj = mapper.findAll(PageRequest.of(pageNO-1,3));
            redisUtil.set("selectAll"+pageNO,obj,60*1);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        return obj;
    }

    @Override
    public UserBean selectById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public UserBean selectByName(String name) {
        return mapper.selectByName(name);
    }
}
