package com.itxiaoer.dis.store;

import com.itxiaoer.dis.store.redis.DisRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : liuyk
 */
@ComponentScan
@Configuration
@Import(DisRedisAutoConfiguration.class)
@EnableConfigurationProperties(DisStoreProperties.class)
@ConditionalOnProperty(value = "spring.dis.active", havingValue = "true")
public class DisStoreAutoConfiguration {
}