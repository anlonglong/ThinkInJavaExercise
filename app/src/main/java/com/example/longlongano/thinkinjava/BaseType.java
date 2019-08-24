package com.example.longlongano.thinkinjava;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/8/24 上午9:37
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseType {
    String listenerMethod() default "";
    Class<?> listenerType() default View.class;
    String callback() default "onClick()";
}
