package com.example.longlongano.thinkinjava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/8/24 上午9:59
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Other {
    int value() default  -1;
}
