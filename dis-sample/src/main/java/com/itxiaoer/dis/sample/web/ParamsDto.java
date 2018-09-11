package com.itxiaoer.dis.sample.web;

import com.itxiaoer.dis.commons.Dis;
import lombok.Data;

@Data
public class ParamsDto implements Dis {
    private String id;
    private String name;

    @Override
    public String dis() {
        return id + name;
    }
}
