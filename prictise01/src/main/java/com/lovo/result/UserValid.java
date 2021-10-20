package com.lovo.result;

import java.lang.annotation.*;

/**
 * 用于是否需要用户认证的标识
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface UserValid {
}
