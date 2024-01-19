package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f4997a;

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f4998a;

        /* renamed from: a  reason: collision with other field name */
        public final T f953a;
    }

    static {
        HashMap hashMap = new HashMap();
        f4997a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f4997a.put(Byte.class, Byte.TYPE);
        f4997a.put(Character.class, Character.TYPE);
        f4997a.put(Short.class, Short.TYPE);
        f4997a.put(Integer.class, Integer.TYPE);
        f4997a.put(Float.class, Float.TYPE);
        f4997a.put(Long.class, Long.TYPE);
        f4997a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f4997a;
        Class cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f4997a;
        Class cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f4997a;
        Class cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f4997a;
        Class cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f4997a;
        Class cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f4997a;
        Class cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f4997a;
        Class cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f4997a;
        Class cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<? extends java.lang.Object>, code=java.lang.Class, for r2v0, types: [java.lang.Class<? extends java.lang.Object>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.Class r2, java.lang.Object r3, java.lang.String r4) {
        /*
            r0 = 0
        L_0x0001:
            r1 = 1
            if (r0 != 0) goto L_0x0019
            java.lang.reflect.Field r0 = r2.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x000c }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x000c }
            goto L_0x0010
        L_0x000c:
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0010:
            if (r2 == 0) goto L_0x0013
            goto L_0x0001
        L_0x0013:
            java.lang.NoSuchFieldException r2 = new java.lang.NoSuchFieldException
            r2.<init>()
            throw r2
        L_0x0019:
            r0.setAccessible(r1)
            java.lang.Object r2 = r0.get(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.z.a(java.lang.Class, java.lang.Object, java.lang.String):java.lang.Object");
    }

    public static <T> T a(Class<? extends Object> cls, String str) {
        try {
            return a(cls, (Object) null, str);
        } catch (Exception e2) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Meet exception when call getStaticField '", str, "' in ");
            outline80.append(cls != null ? cls.getSimpleName() : "");
            outline80.append(", ");
            outline80.append(e2);
            outline80.toString();
            return null;
        }
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        return a(cls, str, (Class<?>[]) a(objArr)).invoke(null, a(objArr));
    }

    public static <T> T a(Object obj, String str) {
        try {
            return a(obj.getClass(), obj, str);
        } catch (Exception e2) {
            "Meet exception when call getField '" + str + "' in " + obj + ", " + e2;
            return null;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return b(obj, str, objArr);
        } catch (Exception e2) {
            "Meet exception when call Method '" + str + "' in " + obj + ", " + e2;
            return null;
        }
    }

    public static <T> T a(String str, String str2) {
        try {
            return a(j.a(null, str), (Object) null, str2);
        } catch (Exception e2) {
            StringBuilder outline82 = GeneratedOutlineSupport.outline82("Meet exception when call getStaticField '", str2, "' in ", str, ", ");
            outline82.append(e2);
            outline82.toString();
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return a(j.a(null, str), str2, objArr);
        } catch (Exception e2) {
            StringBuilder outline82 = GeneratedOutlineSupport.outline82("Meet exception when call Method '", str2, "' in ", str, ", ");
            outline82.append(e2);
            outline82.toString();
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
        if (a2 != null) {
            a2.setAccessible(true);
            return a2;
        } else if (cls.getSuperclass() != null) {
            return a(cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    public static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && a((Class<?>[]) method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Exception e2) {
            "Meet exception when call setField '" + str + "' in " + obj + ", " + e2;
        }
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z = true;
        if (clsArr == null) {
            if (!(clsArr2 == null || clsArr2.length == 0)) {
                z = false;
            }
            return z;
        } else if (clsArr2 == null) {
            if (clsArr.length != 0) {
                z = false;
            }
            return z;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                if (clsArr2[i] != null && !clsArr[i].isAssignableFrom(clsArr2[i]) && (!f4997a.containsKey(clsArr[i]) || !f4997a.get(clsArr[i]).equals(f4997a.get(clsArr2[i])))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            a aVar = objArr[i];
            if (aVar == null || !(aVar instanceof a)) {
                clsArr[i] = aVar == null ? null : aVar.getClass();
            } else {
                clsArr[i] = aVar.f4998a;
            }
        }
        return clsArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Object[] m883a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            a aVar = objArr[i];
            if (aVar == null || !(aVar instanceof a)) {
                objArr2[i] = aVar;
            } else {
                objArr2[i] = aVar.f953a;
            }
        }
        return objArr2;
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        return a(obj.getClass(), str, (Class<?>[]) a(objArr)).invoke(obj, a(objArr));
    }

    public static void b(Object obj, String str, Object obj2) {
        Class cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                continue;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }
}
