package com.itxiaoer.dis.store;

import javax.annotation.Resource;

/**
 * @author : liuyk
 */
public class DisTemplate {
    @Resource
    private DisStore disStore;

    public void setDisStore(DisStore disStore) {
        this.disStore = disStore;
    }
}
