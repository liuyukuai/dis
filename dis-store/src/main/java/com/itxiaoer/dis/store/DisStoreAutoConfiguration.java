package com.itxiaoer.dis.store;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : liuyk
 */
@ComponentScan
@Configuration
@EnableConfigurationProperties(DisStoreProperties.class)
public class DisStoreAutoConfiguration {
}