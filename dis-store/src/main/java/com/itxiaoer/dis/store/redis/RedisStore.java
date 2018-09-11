package com.itxiaoer.dis.store.redis;

import com.itxiaoer.dis.store.DisStore;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : liuyk
 */
public class RedisStore implements DisStore {

    @Resource
    private ValueOperations<String, String> valueOperations;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Boolean setNx(String key, String value, long expireTime) {
        Boolean success = valueOperations.setIfAbsent(key, value);
        if (success != null && success) {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
        return success;
    }

    @Override
    public Boolean delete(String key) {
        return this.redisTemplate.delete(key);
    }

    @Override
    public String get(String key) {
        return this.valueOperations.get(key);
    }
}
