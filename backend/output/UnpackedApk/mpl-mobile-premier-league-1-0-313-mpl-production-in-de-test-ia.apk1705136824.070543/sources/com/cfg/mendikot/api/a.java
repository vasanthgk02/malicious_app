package com.cfg.mendikot.api;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.app.SDKMode;
import okhttp3.MediaType;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f2246a = "https://gate.mpl.mendikot.cfgpro.online";

    /* renamed from: b  reason: collision with root package name */
    public static String f2247b = "wss://relay.mpl.mendikot.cfgpro.online";

    /* renamed from: c  reason: collision with root package name */
    public static String f2248c = GeneratedOutlineSupport.outline62(new StringBuilder(), f2247b, "/game/ws?g=");

    /* renamed from: com.cfg.mendikot.api.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0033a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2249a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.cfg.mendikot.app.SDKMode[] r0 = com.cfg.mendikot.app.SDKMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2249a = r0
                r1 = 1
                com.cfg.mendikot.app.SDKMode r2 = com.cfg.mendikot.app.SDKMode.PROD     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2249a     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.cfg.mendikot.app.SDKMode r3 = com.cfg.mendikot.app.SDKMode.STAGE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2249a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cfg.mendikot.app.SDKMode r2 = com.cfg.mendikot.app.SDKMode.LOCAL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.a.C0033a.<clinit>():void");
        }
    }

    static {
        MediaType.parse("application/json; charset=utf-8");
    }

    public static void a(SDKMode sDKMode) {
        String str;
        int i = C0033a.f2249a[sDKMode.ordinal()];
        if (i == 1) {
            f2246a = "https://gate.mpl.mendikot.cloudfeathergamesapi.co.in";
            str = "wss://mindi-api.mpl.live";
        } else if (i != 2) {
            if (i == 3) {
                f2246a = "https://192.168.0.140:9007";
                str = "ws://192.168.0.140:9001";
            }
            f2248c = GeneratedOutlineSupport.outline62(new StringBuilder(), f2247b, "/game/ws?g=");
        } else {
            f2246a = "https://gate.mpl.mendikot.cfgpro.online";
            str = "wss://relay.mpl.mendikot.cfgpro.online";
        }
        f2247b = str;
        f2248c = GeneratedOutlineSupport.outline62(new StringBuilder(), f2247b, "/game/ws?g=");
    }
}
