package com.itxiaoer.dis.store;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : liuyk
 */
@ComponentScan
@Configuration
@EnableConfigurationProperties(DisStoreProperties.class)
@ConditionalOnProperty(value = "spring.dis.active", havingValue = "true")
public class DisStoreAutoConfiguration {
}