package com.itxiaoer.dis.store;

/**
 * dis store
 *
 * @author : liuyk
 */
public interface DisStore {
    /**
     * set key and value
     *
     * @param key        key
     * @param value      value
     * @param expireTime expireTime unit: seconds
     * @return
     */
    Boolean setNx(String key, String value, long expireTime);

}
