package java8.util.concurrent;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeAcc {
    public static final Unsafe unsafe;

    static {
        Field field;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException unused) {
            try {
                field = Unsafe.class.getDeclaredField("THE_ONE");
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }
        field.setAccessible(true);
        unsafe = (Unsafe) field.get(null);
    }
}
