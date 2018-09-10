package com.itxiaoer.dis.store;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * dis store config
 *
 * @author : liuyk
 */
@Data
@ConfigurationProperties(prefix = "spring.dis.store")
public class DisStoreProperties {
    private String type;
}
