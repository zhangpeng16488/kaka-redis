package com.zhang;

import redis.clients.jedis.Jedis;

/**
 * @auther kaka
 * @create 2021-02-09 10:15
 */
public class TestPing {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("47.100.41.55",6379);
        String ping = jedis.ping();
        //验证密码，如果没有设置密码这段代码省略
        // jedis.auth("password"); jedis.connect();
        // 连接 jedis.disconnect();
        // 断开连接 jedis.flushAll();
        // 清空所有的key
        System.out.println(ping);
    }
}
