package com.itxiaoer.dis.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate disRedisTemplate(@Autowired RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate disRedisTemplate = new RedisTemplate<>();
        disRedisTemplate.setConnectionFactory(redisConnectionFactory);
        disRedisTemplate.setDefaultSerializer(new StringRedisSerializer());
        disRedisTemplate.setValueSerializer(new StringRedisSerializer());
        disRedisTemplate.setKeySerializer(new StringRedisSerializer());
        disRedisTemplate.afterPropertiesSet();
        return disRedisTemplate;
    }

}
