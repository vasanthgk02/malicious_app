package com.mpl.androidapp.exception;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import timber.log.Timber;

public class HookActivityManager {
    public static final String TAG = "HookActivityManager";

    public static class IActivityManagerProxy implements InvocationHandler {
        public final Object mActivityManager;

        public IActivityManagerProxy(Object obj) {
            this.mActivityManager = obj;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("reportSizeConfigurations".equals(method.getName())) {
                try {
                    Timber.TREE_OF_SOULS.w("%s reportSizeConfigurations invoke execute ", HookActivityManager.TAG);
                    return method.invoke(this.mActivityManager, objArr);
                } catch (IllegalArgumentException | UndeclaredThrowableException e2) {
                    Timber.TREE_OF_SOULS.w("%s reportSizeConfigurations IllegalArgumentException %s ", HookActivityManager.TAG, e2.getMessage());
                    return null;
                } catch (InvocationTargetException e3) {
                    Timber.TREE_OF_SOULS.w("%s reportSizeConfigurations InvocationTargetException %s ", HookActivityManager.TAG, e3.getMessage());
                    return null;
                } catch (Error | Exception e4) {
                    Timber.TREE_OF_SOULS.w("%s reportSizeConfigurations exception %s ", HookActivityManager.TAG, e4.getMessage());
                    return null;
                }
            } else if (!"isTopOfTask".equals(method.getName())) {
                return method.invoke(this.mActivityManager, objArr);
            } else {
                try {
                    Timber.TREE_OF_SOULS.w("%s isTopOfTask invoke execute ", HookActivityManager.TAG);
                    return method.invoke(this.mActivityManager, objArr);
                } catch (IllegalArgumentException | UndeclaredThrowableException e5) {
                    Timber.TREE_OF_SOULS.w("%s isTopOfTask IllegalArgumentException %s ", HookActivityManager.TAG, e5.getMessage());
                    return Boolean.FALSE;
                } catch (InvocationTargetException e6) {
                    Timber.TREE_OF_SOULS.w("%s isTopOfTask InvocationTargetException %s ", HookActivityManager.TAG, e6.getMessage());
                    return Boolean.FALSE;
                } catch (Error | Exception e7) {
                    Timber.TREE_OF_SOULS.w("%s isTopOfTask exception %s ", HookActivityManager.TAG, e7.getMessage());
                    return Boolean.FALSE;
                }
            }
        }
    }

    public static void hook() {
        int i = VERSION.SDK_INT;
        if (i == 26 || i == 28 || i == 27) {
            try {
                Field declaredField = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj != null) {
                    Class<? super T> superclass = obj.getClass().getSuperclass();
                    if (superclass != null) {
                        Field declaredField2 = superclass.getDeclaredField("mInstance");
                        declaredField2.setAccessible(true);
                        Object obj2 = declaredField2.get(obj);
                        Class<?> cls = Class.forName("android.app.IActivityManager");
                        declaredField2.set(obj, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new IActivityManagerProxy(obj2)));
                        Timber.TREE_OF_SOULS.i("%s hook success!", TAG);
                    }
                }
            } catch (Exception e2) {
                Timber.TREE_OF_SOULS.w("%s hook exception %s", TAG, e2.getMessage());
            }
        } else {
            Timber.TREE_OF_SOULS.i("%s hook return, not match version", TAG);
        }
    }
}
