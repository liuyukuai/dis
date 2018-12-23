package com.itxiaoer.dis.store;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * dis store config
 *
 * @author : liuyk
 */
@Data
@ConfigurationProperties(prefix = "spring.dis.store")
public class DisStoreProperties {
    @Value("${spring.dis.store.type:redis}")
    private String type;
}
