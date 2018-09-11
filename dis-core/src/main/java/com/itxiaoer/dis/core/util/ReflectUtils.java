package com.itxiaoer.dis.core.util;

import com.itxiaoer.dis.commons.Dis;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author : liuyk
 */
@Slf4j
@SuppressWarnings("all")
public final class ReflectUtils {

    public static String find(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        try {
            Annotation[][] annotations = joinPoint.getTarget().getClass().getMethod(methodName, parameterTypes).getParameterAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                Annotation[] annotation = annotations[i];
                for (Annotation annotation1 : annotation) {
                    sb.append(parse(args[i]));
                }
            }
            return sb.toString();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String parse(Object obj) {
        if (Objects.isNull(obj)) {
            return "";
        }

        // implements Dis
        if (obj instanceof Dis) {
            Dis dis = (Dis) obj;
            return dis.dis();
        }

        // is collection
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            return collection.isEmpty() ? "" : collection.toString();
        }

        // is map
        if (obj instanceof Map) {
            Map map = (Map) obj;
            return map.isEmpty() ? "" : map.toString();
        }
        return obj.toString();
    }


    public static boolean invoke(String clazzName, String method, Object object) {
        try {
            return invoke(Class.forName(clazzName), method, object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean invoke(Class<?> clazz, String method, Object object) {
        try {
            return (Boolean) clazz.getMethod(method).invoke(object);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

}
