package com.itxiaoer.dis.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : liuyk
 */
@Slf4j
@Aspect
@Component
public class DisAspect {

    @Pointcut("@annotation(com.itxiaoer.dis.commons.annotation.Dis)")
    private void dis() {
    }


    @Before("dis()")
    public void before(JoinPoint joinPoint) {
        log.info("before {}", joinPoint);
    }

    @After("dis()")
    public void after(JoinPoint joinPoint) {
        log.info("after {}", joinPoint);

    }
}
