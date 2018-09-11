package com.itxiaoer.dis.commons.exception;

/**
 * @author : liuyk
 */
@SuppressWarnings("unused")
public class DisException extends RuntimeException {


    public DisException(String message) {
        super(message);
    }

    public DisException(String message, Throwable cause) {
        super(message, cause);
    }

    public DisException(Throwable cause) {
        super(cause);
    }

    protected DisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
