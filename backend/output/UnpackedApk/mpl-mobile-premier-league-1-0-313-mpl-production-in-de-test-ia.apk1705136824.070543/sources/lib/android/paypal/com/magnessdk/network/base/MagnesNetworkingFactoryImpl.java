package lib.android.paypal.com.magnessdk.network.base;

import lib.android.paypal.com.magnessdk.c$h$b;

public final class MagnesNetworkingFactoryImpl {

    /* renamed from: lib.android.paypal.com.magnessdk.network.base.MagnesNetworkingFactoryImpl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6125a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                lib.android.paypal.com.magnessdk.c$h$b[] r0 = lib.android.paypal.com.magnessdk.c$h$b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6125a = r0
                lib.android.paypal.com.magnessdk.c$h$b r1 = lib.android.paypal.com.magnessdk.c$h$b.GET     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f6125a     // Catch:{ NoSuchFieldError -> 0x0016 }
                lib.android.paypal.com.magnessdk.c$h$b r1 = lib.android.paypal.com.magnessdk.c$h$b.POST     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.base.MagnesNetworkingFactoryImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public MagnesNetworking createHttpClient(c$h$b c_h_b) throws Exception {
        int i = AnonymousClass1.f6125a[c_h_b.ordinal()];
        return i != 1 ? i != 2 ? new b() : new b() : new a();
    }
}
