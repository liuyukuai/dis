package com.itxiaoer.sample.web;

import com.itxiaoer.dis.commons.DisResponse;
import lombok.Data;

import java.util.Objects;

/**
 * @author : liuyk
 */
@Data
@SuppressWarnings("all")
public class MyResponse<T> implements DisResponse<T> {

    /**
     * code
     */
    private String code;
    /**
     * message
     */
    private String msg;


    private T data;

    private boolean success;

    @Override
    public boolean isSuccess() {
        return success;
    }

    /**
     * private
     */
    private MyResponse() {
    }

    /**
     * private
     */
    private MyResponse(T data) {
        this.success = true;
        this.data = data;
    }


    private MyResponse(boolean success, String msg) {
        this(success, msg, "0");
    }

    private MyResponse(boolean success, String msg, String code) {
        this.msg = msg;
        this.success = success;
        this.code = code;
    }


    public static <E> MyResponse<E> success() {
        return new MyResponse<>(null);
    }

    public static <E> MyResponse<E> success(E data) {
        return new MyResponse<>(data);
    }


    public static <E> MyResponse<E> fail(String msg) {
        return new MyResponse<>(false, msg);
    }


    public static <E> MyResponse<E> fail(String msg, String code) {
        return new MyResponse<>(false, msg);
    }

    public static MyResponse<Boolean> build(Boolean success) {
        if (Objects.equals(success, Boolean.TRUE)) {
            return new MyResponse<>(Boolean.TRUE);
        }
        return new MyResponse<>(false, "");
    }

}
