package com.itxiaoer.dis.sample.web;

import com.itxiaoer.dis.commons.exception.DisException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : liuyk
 */
@Slf4j
@ControllerAdvice
public class ExceptionAdvice {


    @ResponseBody
    @SuppressWarnings("unchecked")
    @ExceptionHandler({DisException.class})
    public <T> MyResponse<T> handleDisException(DisException e) {
        //log.error(e.getMessage(), e);
        return MyResponse.fail(e.getMessage());
    }


}
