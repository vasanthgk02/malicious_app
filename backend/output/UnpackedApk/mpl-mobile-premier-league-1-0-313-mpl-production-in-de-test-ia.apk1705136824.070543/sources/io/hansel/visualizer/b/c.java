package io.hansel.visualizer.b;

public class c {
    public static RuntimeException a(Throwable th) {
        a(th, Error.class);
        a(th, RuntimeException.class);
        throw new RuntimeException(th);
    }

    public static <T extends Throwable> void a(Throwable th, Class<T> cls) {
        if (cls.isInstance(th)) {
            throw th;
        }
    }
}
