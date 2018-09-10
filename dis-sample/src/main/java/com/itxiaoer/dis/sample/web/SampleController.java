package com.itxiaoer.dis.sample.web;

import com.itxiaoer.dis.commons.annotation.Dis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : liuyk
 */
@RestController
public class SampleController {

    @Dis(value = "app")
    @GetMapping("/sample")
    public String create() {
        return "hello !";
    }
}
