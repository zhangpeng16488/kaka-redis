package com.zhang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

//        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("kaka","孙悟空sun");
        System.out.println(redisTemplate.opsForValue().get("kaka"));
    }

}
