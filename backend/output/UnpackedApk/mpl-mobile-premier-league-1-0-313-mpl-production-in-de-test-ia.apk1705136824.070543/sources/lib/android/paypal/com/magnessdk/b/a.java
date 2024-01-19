package lib.android.paypal.com.magnessdk.b;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f5963f = Boolean.valueOf(System.getProperty("magnes.debug.mode", Boolean.FALSE.toString())).booleanValue();

    public static void a(Class<?> cls, int i, String str) {
        boolean z = f5963f;
        if (!z) {
            return;
        }
        if (i == 0 || i == 1 || i == 2 || (i == 3 && z)) {
            cls.getSimpleName();
        }
    }

    public static void a(Class<?> cls, int i, Throwable th) {
        boolean z = f5963f;
        if (!z) {
            return;
        }
        if (i == 0 || i == 1 || i == 2 || (i == 3 && z)) {
            cls.getSimpleName();
            th.getMessage();
        }
    }
}
