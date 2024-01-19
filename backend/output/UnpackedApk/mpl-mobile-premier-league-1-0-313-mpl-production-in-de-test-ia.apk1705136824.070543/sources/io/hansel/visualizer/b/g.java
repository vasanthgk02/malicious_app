package io.hansel.visualizer.b;

public class g {
    public static void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean z) {
        if (z) {
            throw new IllegalStateException();
        }
    }

    public static <T> T b(T t) {
        t.getClass();
        return t;
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
