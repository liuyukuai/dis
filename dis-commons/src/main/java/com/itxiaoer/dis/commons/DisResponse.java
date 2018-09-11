package com.itxiaoer.dis.commons;

/**
 * dis response
 *
 * @author : liuyk
 */
@SuppressWarnings("unused")
public interface DisResponse<T> {
    /**
     * check response is success
     *
     * @return true: success,false: fail
     */
    boolean isSuccess();
}
