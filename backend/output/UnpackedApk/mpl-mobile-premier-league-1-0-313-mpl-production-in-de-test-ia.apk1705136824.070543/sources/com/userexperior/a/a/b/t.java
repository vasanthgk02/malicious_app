package com.userexperior.a.a.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class t {
    public static t a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", new Class[]{Class.class});
            return new t() {
                public final <T> T a(Class<T> cls) throws Exception {
                    t.b(cls);
                    return method.invoke(obj, new Object[]{cls});
                }
            };
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                final int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new t() {
                    public final <T> T a(Class<T> cls) throws Exception {
                        t.b(cls);
                        return declaredMethod2.invoke(null, new Object[]{cls, Integer.valueOf(intValue)});
                    }
                };
            } catch (Exception unused2) {
                try {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new t() {
                        public final <T> T a(Class<T> cls) throws Exception {
                            t.b(cls);
                            return declaredMethod3.invoke(null, new Object[]{cls, Object.class});
                        }
                    };
                } catch (Exception unused3) {
                    return new t() {
                        public final <T> T a(Class<T> cls) {
                            throw new UnsupportedOperationException("Cannot allocate ".concat(String.valueOf(cls)));
                        }
                    };
                }
            }
        }
    }

    public static /* synthetic */ void b(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException(GeneratedOutlineSupport.outline35(cls, new StringBuilder("Interface can't be instantiated! Interface name: ")));
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException(GeneratedOutlineSupport.outline35(cls, new StringBuilder("Abstract class can't be instantiated! Class name: ")));
        }
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}