package com.itxiaoer.dis.core.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;

/**
 * @author : liuyk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Md5ID implements ID {

    private String appKey;

    private String content;

    @Override
    public String id() {
        Assert.hasText(appKey, "appKey is empty.");
        Assert.hasText(content, "content is empty.");
        return DigestUtils.md5DigestAsHex((appKey + content).getBytes(Charset.defaultCharset()));
    }
}
