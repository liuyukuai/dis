package com.itxiaoer.dis.store.id;

import com.itxiaoer.dis.commons.exception.DisException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

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
        if (StringUtils.isEmpty(appKey)) {
            throw new DisException("this appKey argument must have length; it must not be null or empty");
        }

        if (StringUtils.isEmpty(content)) {
            throw new DisException("this content argument must have length; it must not be null or empty");
        }

        return DigestUtils.md5DigestAsHex((appKey + content).getBytes(Charset.defaultCharset()));
    }
}
