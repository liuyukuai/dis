package com.itxiaoer.dis.store.redis;

import com.itxiaoer.dis.store.DisStore;
import com.itxiaoer.dis.store.constant.DisStoreConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * dis redis auto configuration
 *
 * @author : liuyk
 */
@Configuration
@ConditionalOnProperty(name = "spring.dis.store.type", havingValue = DisStoreConstants.STORE_TYPE_REDIS)
public class DisRedisAutoConfiguration {

    @Bean
    public DisStore disStore() {
        return new RedisStore();
    }
}
