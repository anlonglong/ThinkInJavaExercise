package com.example.longlongano.thinkinjava;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/8/24 上午9:40
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@BaseType(
        listenerMethod = "setOnClickListener",
        listenerType = View.OnClickListener.class,
        callback = "onClick")
public @interface OnClick {
    int[] value();
}
