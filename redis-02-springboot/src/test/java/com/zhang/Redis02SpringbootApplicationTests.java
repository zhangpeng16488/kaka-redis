package com.zhang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.pojo.User;
import com.zhang.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Collection;


@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedisUtil(){
        redisUtil.set("fuck","you");
        System.out.println(redisUtil.get("fuck"));
    }

    @Test
    public void testDelKeys(){
        //删除两个key
        redisUtil.del("user","fuck");
    }

    @Test
    public void testCollectionsArray2List(){
        System.out.println((Collection<String>) CollectionUtils.arrayToList("user"));
    }


    @Test
    void contextLoads() {

//        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("kaka","孙悟空sun");
        System.out.println(redisTemplate.opsForValue().get("kaka"));

        redisTemplate.opsForValue().set("what","fuck");
        System.out.println(redisTemplate.opsForValue().get("what"));
    }

    @Test
    public void testUser() throws JsonProcessingException {

        //真实的开发一般使用json来传递对象
        User user = new User("卡卡罗特", 18);
//        String value = new ObjectMapper().writeValueAsString(user);

        //直接传对象会报错，因此需要序列化
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
