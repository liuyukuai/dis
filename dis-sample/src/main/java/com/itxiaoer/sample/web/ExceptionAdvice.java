package com.itxiaoer.sample.web;

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
    @ExceptionHandler({DisException.class})
    public <T> MyResponse<T> handleDisException(DisException e) {
        return MyResponse.fail(e.getMessage());
    }


}
