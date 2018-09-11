package com.itxiaoer.dis.core;

import com.itxiaoer.dis.core.config.DisProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : liuyk
 */
@Configuration
@ComponentScan("com.itxiaoer.dis")
@EnableConfigurationProperties(DisProperties.class)
@ConditionalOnProperty(value = "spring.dis.active", havingValue = "true")
public class DisAutoConfiguration {
}
