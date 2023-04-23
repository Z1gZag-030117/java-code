package com.zz.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 朱喆
 * @version 1.0
 */
public class JedisConnectionFactory {
    private static final JedisPool jedispool;

    static {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);

        jedispool = new JedisPool(poolConfig, "192.168.120.200", 6379, 1000, "123456");
    }

    public static Jedis getJedis() {
        return jedispool.getResource();
    }

}
