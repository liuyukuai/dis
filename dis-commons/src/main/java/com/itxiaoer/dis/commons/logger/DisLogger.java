package com.itxiaoer.dis.commons.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : liuyk
 */
@Component
public class DisLogger {
    private static final Map<Class<?>, Logger> LOGGER_MAP = new ConcurrentHashMap<>();


    private Logger get(Class<?> clazz) {
        Logger logger = LOGGER_MAP.get(clazz);
        if (logger == null) {
            logger = LoggerFactory.getLogger(clazz);
            LOGGER_MAP.put(clazz, LoggerFactory.getLogger(clazz));
        }
        return logger;
    }

    public void debug(Class<?> clazz, String message, Object... args) {
        Logger logger = this.get(clazz);
        if (logger.isDebugEnabled()) {
            logger.debug(message, args);
        }
    }

    public void info(Class<?> clazz, String message, Object... args) {
        this.get(clazz).info(message, args);
    }

    public void error(Class<?> clazz, String message, Throwable e, Object... args) {
        this.get(clazz).error(message, e, args);
    }
}
