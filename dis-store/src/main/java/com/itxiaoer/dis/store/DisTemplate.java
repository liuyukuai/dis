package com.itxiaoer.dis.store;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : liuyk
 */

@Component
@SuppressWarnings("unused")
public class DisTemplate {

    @Resource
    private DisStore disStore;

    public Boolean setNx(String id, String content, long expireTime) {
        return this.disStore.setNx(id, content, expireTime);
    }


    public Boolean delete(String key) {
        return this.disStore.delete(key);
    }

    public String get(String key) {
        return this.disStore.get(key);
    }
}
