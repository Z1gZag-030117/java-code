package com.zz.test;

import com.zz.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author 朱喆
 * @version 1.0
 */
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setJedis() {
        //1.建立连接
        //jedis=new Jedis("192.168.120.200",6379);
        jedis = JedisConnectionFactory.getJedis();
        //2.设置密码
        jedis.auth("123456");
        //3.选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "zs");
        System.out.println("result=" + result);

        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash() {
        jedis.hset("user:1", "name", "ls");
        jedis.hset("user:1", "age", "100");

        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
