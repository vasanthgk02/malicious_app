package lib.android.paypal.com.magnessdk;

public enum c$k {
    KNOWN_ROOT_APPS_PACKAGES("com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk"),
    SU_PATHS("/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/system/xbin/daemonsu/", "/system/etc/init.d/99SuperSUDaemon/", "/system/bin/.ext/.su/", "/system/etc/.has_su_daemon/", "/system/etc/.installed_su_daemon/", "/cache/", "/data/", "/dev/");
    

    /* renamed from: c  reason: collision with root package name */
    public final String[] f6082c;

    public enum a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6083a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final a f6084b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final a f6085c = null;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ a[] f6086e = null;

        /* renamed from: d  reason: collision with root package name */
        public final String f6087d;

        /* access modifiers changed from: public */
        static {
            f6083a = new a("SU", 0, "su");
            f6084b = new a("BUSYBOX", 1, "busybox");
            a aVar = new a("MAGISK", 2, "magisk");
            f6085c = aVar;
            f6086e = new a[]{f6083a, f6084b, aVar};
        }

        /* access modifiers changed from: public */
        a(String str, int i, String str2) {
            this.f6087d = str2;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f6086e.clone();
        }

        public String toString() {
            return this.f6087d;
        }
    }

    public enum b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f6088a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final b f6089b = null;

        /* renamed from: c  reason: collision with root package name */
        public static final b f6090c = null;

        /* renamed from: d  reason: collision with root package name */
        public static final b f6091d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final b f6092e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final b f6093f = null;
        public static final b g = null;
        public static final b h = null;
        public static final /* synthetic */ b[] j = null;
        public final int i;

        /* access modifiers changed from: public */
        static {
            f6088a = new b("NUMBER_OF_ROOTED_FLAGS", 0, 7);
            f6089b = new b("IS_TEST_KEYS_FOUND", 1, 0);
            f6090c = new b("IS_SU_FOUND", 2, 1);
            f6091d = new b("IS_SUPER_USER_APK_FOUND", 3, 2);
            f6092e = new b("DETECT_ROOT_MANAGEMENT_APPS", 4, 3);
            f6093f = new b("CHECK_FOR_BINARY_SU", 5, 4);
            g = new b("CHECK_FOR_BINARY_BUSYBOX", 6, 5);
            b bVar = new b("CHECK_FOR_BINARY_MAGISK", 7, 6);
            h = bVar;
            j = new b[]{f6088a, f6089b, f6090c, f6091d, f6092e, f6093f, g, bVar};
        }

        /* access modifiers changed from: public */
        b(String str, int i2, int i3) {
            this.i = i3;
        }

        public static b a(int i2) {
            if (i2 == f6089b.a()) {
                return f6089b;
            }
            if (i2 == f6090c.a()) {
                return f6090c;
            }
            if (i2 == f6091d.a()) {
                return f6091d;
            }
            if (i2 == f6092e.a()) {
                return f6092e;
            }
            if (i2 == f6093f.a()) {
                return f6093f;
            }
            if (i2 == g.a()) {
                return g;
            }
            if (i2 == h.a()) {
                return h;
            }
            return null;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) j.clone();
        }

        public int a() {
            return this.i;
        }
    }

    /* access modifiers changed from: public */
    c$k(String... strArr) {
        this.f6082c = strArr;
    }

    public String[] a() {
        return this.f6082c;
    }
}
