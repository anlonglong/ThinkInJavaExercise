package com.example.longlongano.thinkinjava;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Description: ${DESCRIPTION}
 * @CreateDate: 2019/8/24 上午11:50
 * @Author: longlong.an
 * @Email: longlong.an.o@nio.com
 */
public class MiInvoHandler implements InvocationHandler {
    private static final String TAG = "MiInvoHandler";

    private Object mObject;
    HashMap<String, Method> mMethod = new HashMap<>();

    public MiInvoHandler(Object object) {
        mObject = object;

    }

    public void addMethod(String nmae, Method method) {
        mMethod.put(nmae, method);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (null != mObject) {
            Method method1 = mMethod.get(method.getName());
            Log.i(TAG, "invoke: -------");
            if (null != method1) {
                method1.invoke(mObject, args);
            }
        }
        return null;
    }
}
