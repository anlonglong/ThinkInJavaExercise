package com.example.longlongano.thinkinjava;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/8/24 上午9:36
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class InjectUtils {
    private static final String TAG = "InjectUtils";

    public static void injectOnClick(final Activity o) {
        Class<?> clazz = o.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (final Method method : declaredMethods) {
            Annotation[] annotations = method.getDeclaredAnnotations();

            if (annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    BaseType baseType = annotationType.getAnnotation(BaseType.class);
                    if (null != baseType) {
                        String callback = baseType.callback();
                        final String listenerMethod = baseType.listenerMethod();
                        Class<?> listenerType = baseType.listenerType();
                        Log.i(TAG, "callback : " + callback);
                        Log.i(TAG, "listenerMethod : " + listenerMethod);
                        Log.i(TAG, "listenerType : " + listenerType);
                        Class<? extends Annotation> annClazz = annotation.getClass();
                        View[] views = null;
                        try {
                            Method annClazzMethod = annClazz.getMethod("value");
                            try {
                                int[] values = (int[]) annClazzMethod.invoke(annotation);
                                views = new View[values.length];
                                for (int i = 0; i < values.length; i++) {
                                    views[i] = o.findViewById(values[i]);
                                }
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        for (View view : views) {
                            try {
                                Method onClickMethod = view.getClass().getMethod(listenerMethod,
                                        listenerType);
                                try {
                                    final Proxy p = (Proxy) Proxy.newProxyInstance(listenerType
                                            .getClassLoader(), new Class[]{listenerType}, new
                                            InvocationHandler() {

                                                @Override
                                                public Object invoke(Object proxy, Method m,
                                                                     Object[]
                                                        args) throws Throwable {
                                                    //这里打应log的时候，不要直接输出proxy这个参数，否则会出现oom。但是可以调用里面的一个参数。

//                                                    主要写了注解处理点击事件的方法
                                                    Log.i(TAG, "method = [" + m
                                                            + "], args = [" + args + "]" + proxy
                                                            .getClass());
                                                    method.invoke(o, args);
                                                    return null;
                                                }
                                            });
                                    onClickMethod.invoke(view, p);
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printParams(Method method, Annotation[] annotations) {
        OnClick annotation = method.getAnnotation(OnClick.class);
        if (null != annotation) {
            Log.i(TAG, "injectOnClick: onclick : value = " + annotation.value());
        }
        Log.i(TAG, "injectOnClick: array = " + Arrays.toString(annotations));
    }

    public static void injectOnClick2(final Activity o) {
        Class<?> clazz = o.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            OnClick onClick = method.getAnnotation(OnClick.class);
            BaseType baseType;
            if (null != onClick && (baseType = onClick.annotationType().getAnnotation(BaseType
                    .class)) != null) {
                String listenerMethod = baseType.listenerMethod();
                Class<?> listenerType = baseType.listenerType();
                String callback = baseType.callback();
                int[] values = onClick.value();
                View[] views = new View[values.length];
                for (int i = 0; i < values.length; i++) {
                    views[i] = o.findViewById(values[i]);
                }
                MiInvoHandler miInvoHandler = new MiInvoHandler(o);
                miInvoHandler.addMethod(callback, method);
                Proxy proxy = (Proxy) Proxy.newProxyInstance(listenerType.getClassLoader(), new
                        Class[]{listenerType}, miInvoHandler);
                for (View view : views) {
                    try {
                        Method originMethod = view.getClass().getMethod(listenerMethod,
                                listenerType);
                        try {
                            originMethod.invoke(view, proxy);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
