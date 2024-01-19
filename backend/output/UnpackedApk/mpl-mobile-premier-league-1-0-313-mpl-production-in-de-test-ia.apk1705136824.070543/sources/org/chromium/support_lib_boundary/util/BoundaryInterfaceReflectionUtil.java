package org.chromium.support_lib_boundary.util;

import android.annotation.SuppressLint;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SuppressLint({"BanTargetApiAnnotation"})
public class BoundaryInterfaceReflectionUtil {
    public static <T> T castToSuppLibClass(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
