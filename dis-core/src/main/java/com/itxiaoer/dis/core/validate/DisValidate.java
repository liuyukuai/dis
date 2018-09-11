package com.itxiaoer.dis.core.validate;

import com.itxiaoer.dis.core.config.DisProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author : liuyk
 */
@Component
@SuppressWarnings("all")
public class DisValidate implements CommandLineRunner {

    @Resource
    private DisProperties disProperties;

    @Override
    public void run(String... args) throws Exception {
        this.validate();
    }


    public void validate() {

        Assert.hasText(disProperties.getAppId(), "appId argument must have text; it must not be null, empty, or blank");
    }


    public void validate(String response, String state) {
        try {
            Class<?> clazz = Class.forName(response);
            // method
            Method method = clazz.getMethod(state);
        } catch (Exception e) {
            throw new IllegalArgumentException("class " + response + " not found.  or method " + state + " not found. ");
        }
    }

}
