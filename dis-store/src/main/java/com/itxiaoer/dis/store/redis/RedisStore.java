package com.itxiaoer.dis.store.redis;

import com.itxiaoer.dis.store.DisStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : liuyk
 */
public class RedisStore implements DisStore {

    @Resource
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "disRedisTemplate")
    private RedisTemplate<String, String> disRedisTemplate;

    @Autowired
    private RedisScript nxScript;

    @Override
    public Boolean setNx(String key, String value, long expireTime) {
        Object execute = disRedisTemplate.execute(nxScript,Arrays.asList(key),value,String.valueOf(expireTime));
        return (Boolean) execute;
    }

    @Override
    public Boolean delete(String key) {
        return this.disRedisTemplate.delete(key);
    }

    @Override
    public String get(String key) {
        return this.disRedisTemplate.opsForValue().get(key);
    }
}
