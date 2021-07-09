package com.itxiaoer.dis.store.redis;

import com.itxiaoer.dis.store.DisStore;
import com.itxiaoer.dis.store.constant.DisStoreConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.IOException;

/**
 * dis redis auto configuration
 *
 * @author : liuyk
 */
@Configuration
@ConditionalOnProperty(name = "spring.dis.store.type", havingValue = DisStoreConstants.STORE_TYPE_REDIS, matchIfMissing = true)
public class DisRedisAutoConfiguration {

    @Bean
    public DisStore disRemoteStore() {
        return new RedisStore();
    }

    @Bean
    public RedisScript<Boolean> nxScript() throws IOException {
        ScriptSource scriptSource = new ResourceScriptSource(new ClassPathResource("META-INF/scripts/setnx.lua"));
        return RedisScript.of(scriptSource.getScriptAsString(), Boolean.class);
    }
}
