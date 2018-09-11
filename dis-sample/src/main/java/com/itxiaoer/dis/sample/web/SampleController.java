package com.itxiaoer.dis.sample.web;

import com.itxiaoer.dis.commons.annotation.Dis;
import com.itxiaoer.dis.commons.annotation.DisInclude;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : liuyk
 */
@RestController
public class SampleController {

    @Dis(expireTime = 1000)
    @GetMapping("/sample")
    public MyResponse<String> create1(@DisInclude String name, @DisInclude String id, @DisInclude Map<String, String> params) {
        System.out.println("hello " + name);
        return MyResponse.success("hello !" + name);
    }


    @Dis(expireTime = 1000)
    @GetMapping("/sample1")
    public MyResponse<String> create2(@DisInclude ParamsDto paramsDto, @DisInclude String age) {
        System.out.println("hello " + paramsDto.getName());
        return MyResponse.success("hello !" + paramsDto.getName());
    }

}
