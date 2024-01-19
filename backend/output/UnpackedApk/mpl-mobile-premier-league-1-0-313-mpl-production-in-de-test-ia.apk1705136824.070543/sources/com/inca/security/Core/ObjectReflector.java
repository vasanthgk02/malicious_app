package com.inca.security.Core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ObjectReflector<T> {
    private Field field;
    private String fieldName;
    private boolean inited;
    private Object obj;

    public ObjectReflector(Object obj2, String str) {
        this.obj = obj2;
        this.fieldName = str;
    }

    private void prepare() {
        if (!this.inited) {
            this.inited = true;
            Class cls = this.obj.getClass();
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.fieldName);
                    declaredField.setAccessible(true);
                    this.field = declaredField;
                    return;
                } catch (Exception unused) {
                } finally {
                    cls.getSuperclass();
                }
            }
        }
    }

    public T get() throws Exception {
        prepare();
        Field field2 = this.field;
        if (field2 != null) {
            return field2.get(this.obj);
        }
        throw new NoSuchFieldException();
    }

    public void set(T t) throws Exception {
        prepare();
        Field field2 = this.field;
        if (field2 != null) {
            field2.set(this.obj, t);
            return;
        }
        throw new NoSuchFieldException();
    }

    public static Class<?> findInnerClass(Object obj2, String str) {
        for (Class cls = obj2.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Class<?> cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().equals(str)) {
                    return cls2;
                }
            }
        }
        return null;
    }

    public static Method findMethod(Object obj2, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj2.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj2.getClass());
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
        }
    }

    public static Field findField(Object obj2, String str) throws NoSuchFieldException {
        Class cls = obj2.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj2.getClass());
    }

    public static void expandFieldArray(Object obj2, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj2, str);
        Object[] objArr2 = (Object[]) findField.get(obj2);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj2, objArr3);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return findMethod(cls, str, clsArr).invoke(null, objArr);
    }
}
