# dis（Distributed Idempotence Structure）

## 项目介绍
基于Spring Boot + Redis幂等性框架

## 执行流程
在编写中

## 如何使用

### 引入jar包

```xml
<dependency>
    <groupId>com.itxiaoer.dis</groupId>
    <artifactId>dis-core</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 定义返回值类型（必须）

- 因需要判断业务系统执行是否成功，通过DisResponse的方法isSuccess来判断。

```java
package com.itxiaoer.dis.sample.web;

import com.itxiaoer.dis.commons.Responsive;
import lombok.Data;

import java.util.Objects;

/**
 * @author : liuyk
 */
@Data
public class MyResponse<T> implements Responsive{

    private boolean success;

    @Override
    public boolean isSuccess() {
        return success;
    }

}

```
完整例子见dis-sample

 ### 编写请求
 
- 简单参数
```java
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
}

```
- 自定义对象
```java
package com.itxiaoer.dis.sample.web;

import com.itxiaoer.dis.commons.Dis;
import lombok.Data;

/**
 * @author : liuyk
 */
@Data
public class ParamsDto implements Dis {
    private String id;
    private String name;

    @Override
    public String dis() {
        return id + name;
    }
}

```

```java

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
    @GetMapping("/sample1")
    public MyResponse<String> create2(@DisInclude ParamsDto paramsDto, @DisInclude String age) {
        System.out.println("hello " + paramsDto.getName());
        return MyResponse.success("hello !" + paramsDto.getName());
    }
}

```

### 配置 application.yml

```yaml
spring:
  redis:
    host: 127.0.0.1
  dis:
    store:
      type: redis
    active: true
    appId: dis-sample
```

### 全局异常处理
有重复请求目前采用抛出异常方式，所以需要业务自己处理

```java
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
    @ExceptionHandler({DisException.class})
    public <T> MyResponse<T> handleDisException(DisException e) {
        return MyResponse.fail(e.getMessage());
    }
}

```

## 参数说明

- 启动参数

|名称|值|说明|
|----|----|---|
|spring.dis.active|true\|false|是否启用dis|
|spring.dis.appId|应用唯一名称|在微服务架构下，防止请求参数相同|
|spring.dis.store.type|使用存储的类型|redis，目前只支持redis|

- 业务参数

|名称|值|说明|
|----|----|---|
|expireTime|执行业务方法的有效时间|再请求参数一致情况下，该方法多长时间不可重复|

##  注解说明

- @Dis
标注该方法是否要求幂等
- @DisInclude
标注该参数为幂等内容的一部份

## 接口
- Dis
实现Dis接口，并重写dis方法，该方法提供该操作唯一性的内容特性

## License
The project is licensed under the Apache 2 license

