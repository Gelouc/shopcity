package com.lovo;

import com.lovo.service.IUserService;
import com.lovo.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private IUserService service;
    @Resource
    private RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.set("myname","小强");
    }

    @Test
    public void testReadRedis(){
        System.out.println(redisUtil.get("myname"));
    }
}
