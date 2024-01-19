package lib.android.paypal.com.magnessdk.network.base;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import lib.android.paypal.com.magnessdk.MagnesSDK;

public final class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static e f6138a;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<MagnesSDK> f6139d;

    /* renamed from: lib.android.paypal.com.magnessdk.network.base.e$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6140a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|7|8|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                lib.android.paypal.com.magnessdk.c$h$c[] r0 = lib.android.paypal.com.magnessdk.c$h$c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6140a = r0
                r1 = 1
                lib.android.paypal.com.magnessdk.c$h$c r2 = lib.android.paypal.com.magnessdk.c$h$c.GET_REQUEST_STARTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f6140a     // Catch:{ NoSuchFieldError -> 0x0016 }
                lib.android.paypal.com.magnessdk.c$h$c r2 = lib.android.paypal.com.magnessdk.c$h$c.GET_REQUEST_SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 3
                int[] r2 = f6140a     // Catch:{ NoSuchFieldError -> 0x001d }
                lib.android.paypal.com.magnessdk.c$h$c r3 = lib.android.paypal.com.magnessdk.c$h$c.GET_REQUEST_ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r1 = 4
                int[] r2 = f6140a     // Catch:{ NoSuchFieldError -> 0x0024 }
                lib.android.paypal.com.magnessdk.c$h$c r3 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_STARTED     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r0 = f6140a     // Catch:{ NoSuchFieldError -> 0x002b }
                lib.android.paypal.com.magnessdk.c$h$c r2 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f6140a     // Catch:{ NoSuchFieldError -> 0x0032 }
                lib.android.paypal.com.magnessdk.c$h$c r2 = lib.android.paypal.com.magnessdk.c$h$c.POST_REQUEST_ERROR     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.base.e.AnonymousClass1.<clinit>():void");
        }
    }

    public e(Looper looper, MagnesSDK magnesSDK) {
        super(looper);
        this.f6139d = new WeakReference<>(magnesSDK);
    }

    public static synchronized e a(Looper looper, MagnesSDK magnesSDK) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f6138a == null) {
                    f6138a = new e(looper, magnesSDK);
                }
                eVar = f6138a;
            }
        }
        return eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        r3.append(r7.obj);
        r3.append(" error.");
        lib.android.paypal.com.magnessdk.b.a.a(r0, 3, r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        r0 = lib.android.paypal.com.magnessdk.network.base.e.class;
        r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73("GET request to ");
        r1.append(r7.obj);
        r7 = " succeeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0083, code lost:
        r1.append(r7);
        lib.android.paypal.com.magnessdk.b.a.a(r0, 0, r1.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r7) {
        /*
            r6 = this;
            java.lang.ref.WeakReference<lib.android.paypal.com.magnessdk.MagnesSDK> r0 = r6.f6139d
            java.lang.Object r0 = r0.get()
            lib.android.paypal.com.magnessdk.MagnesSDK r0 = (lib.android.paypal.com.magnessdk.MagnesSDK) r0
            if (r0 == 0) goto L_0x008d
            int r0 = r7.what
            lib.android.paypal.com.magnessdk.c$h$c r0 = lib.android.paypal.com.magnessdk.c$h$c.a(r0)
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            int[] r1 = lib.android.paypal.com.magnessdk.network.base.e.AnonymousClass1.f6140a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            java.lang.String r1 = " error."
            r2 = 3
            java.lang.String r3 = "POST request to "
            java.lang.String r4 = "GET request to "
            r5 = 0
            switch(r0) {
                case 1: goto L_0x0060;
                case 2: goto L_0x0076;
                case 3: goto L_0x004a;
                case 4: goto L_0x003c;
                case 5: goto L_0x002e;
                case 6: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x008d
        L_0x0027:
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.e> r0 = lib.android.paypal.com.magnessdk.network.base.e.class
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            goto L_0x0050
        L_0x002e:
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.e> r0 = lib.android.paypal.com.magnessdk.network.base.e.class
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.Object r7 = r7.obj
            r1.append(r7)
            java.lang.String r7 = " successfully."
            goto L_0x0083
        L_0x003c:
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.e> r0 = lib.android.paypal.com.magnessdk.network.base.e.class
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.Object r7 = r7.obj
            r1.append(r7)
            java.lang.String r7 = " started."
            goto L_0x0083
        L_0x004a:
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.e> r0 = lib.android.paypal.com.magnessdk.network.base.e.class
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
        L_0x0050:
            java.lang.Object r7 = r7.obj
            r3.append(r7)
            r3.append(r1)
            java.lang.String r7 = r3.toString()
            lib.android.paypal.com.magnessdk.b.a.a(r0, r2, r7)
            goto L_0x008d
        L_0x0060:
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.e> r0 = lib.android.paypal.com.magnessdk.network.base.e.class
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            lib.android.paypal.com.magnessdk.c$h$d r2 = lib.android.paypal.com.magnessdk.c$h$d.RAMP_CONFIG_URL
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            lib.android.paypal.com.magnessdk.b.a.a(r0, r5, r1)
        L_0x0076:
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.e> r0 = lib.android.paypal.com.magnessdk.network.base.e.class
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.Object r7 = r7.obj
            r1.append(r7)
            java.lang.String r7 = " succeeded"
        L_0x0083:
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            lib.android.paypal.com.magnessdk.b.a.a(r0, r5, r7)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.base.e.handleMessage(android.os.Message):void");
    }
}
