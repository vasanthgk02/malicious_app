package net.minidev.asm;

import java.lang.reflect.Method;

public class DynamicClassLoader extends ClassLoader {
    public static final String BEAN_AC = BeansAccess.class.getName();
    public static final Class<?>[] DEF_CLASS_SIG;

    static {
        Class cls = Integer.TYPE;
        DEF_CLASS_SIG = new Class[]{String.class, byte[].class, cls, cls};
    }

    public DynamicClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    public Class<?> defineClass(String str, byte[] bArr) throws ClassFormatError {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", DEF_CLASS_SIG);
            declaredMethod.setAccessible(true);
            return (Class) declaredMethod.invoke(getParent(), new Object[]{str, bArr, Integer.valueOf(0), Integer.valueOf(bArr.length)});
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }

    public synchronized Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (str.equals(BEAN_AC)) {
            return BeansAccess.class;
        }
        return super.loadClass(str, z);
    }
}
