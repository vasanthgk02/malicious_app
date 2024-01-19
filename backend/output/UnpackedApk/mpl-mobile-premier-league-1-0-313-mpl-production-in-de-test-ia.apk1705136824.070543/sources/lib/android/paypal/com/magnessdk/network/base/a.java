package lib.android.paypal.com.magnessdk.network.base;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class a implements MagnesNetworking {

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6126b;

    /* renamed from: c  reason: collision with root package name */
    public String f6127c = null;

    /* renamed from: d  reason: collision with root package name */
    public Uri f6128d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f6129e;

    public a() throws Exception {
        new f();
        this.f6129e = new HashMap();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int execute(byte[] r10) {
        /*
            r9 = this;
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.a> r10 = lib.android.paypal.com.magnessdk.network.base.a.class
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            android.net.Uri r2 = r9.f6128d     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            lib.android.paypal.com.magnessdk.c$h$a r2 = lib.android.paypal.com.magnessdk.c$h$a.HTTP_READ_TIMEOUT     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            int r2 = r2.a()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            lib.android.paypal.com.magnessdk.c$h$a r2 = lib.android.paypal.com.magnessdk.c$h$a.HTTP_CONNECT_TIMEOUT     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            int r2 = r2.a()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            lib.android.paypal.com.magnessdk.c$h$b r2 = lib.android.paypal.com.magnessdk.c$h$b.GET     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r9.f6129e     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x003f:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r1.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            goto L_0x003f
        L_0x005f:
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r3 = "correlation-id"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r9.f6127c = r3     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r2 != r3) goto L_0x009a
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            lib.android.paypal.com.magnessdk.c$h$a r5 = lib.android.paypal.com.magnessdk.c$h$a.READ_BYTE     // Catch:{ Exception -> 0x0098 }
            int r5 = r5.a()     // Catch:{ Exception -> 0x0098 }
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0098 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0098 }
            r6.<init>()     // Catch:{ Exception -> 0x0098 }
        L_0x0086:
            int r7 = r3.read(r5)     // Catch:{ Exception -> 0x0098 }
            r8 = -1
            if (r7 == r8) goto L_0x0091
            r6.write(r5, r4, r7)     // Catch:{ Exception -> 0x0098 }
            goto L_0x0086
        L_0x0091:
            byte[] r4 = r6.toByteArray()     // Catch:{ Exception -> 0x0098 }
            r9.f6126b = r4     // Catch:{ Exception -> 0x0098 }
            goto L_0x009f
        L_0x0098:
            r2 = move-exception
            goto L_0x00b6
        L_0x009a:
            byte[] r3 = new byte[r4]     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r9.f6126b = r3     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r3 = r0
        L_0x009f:
            lib.android.paypal.com.magnessdk.f.a(r10, r3)
            lib.android.paypal.com.magnessdk.f.a(r10, r0)
            r1.disconnect()
            return r2
        L_0x00a9:
            r2 = move-exception
            r3 = r0
            goto L_0x00d1
        L_0x00ac:
            r2 = move-exception
            r3 = r0
            goto L_0x00b6
        L_0x00af:
            r2 = move-exception
            r1 = r0
            r3 = r1
            goto L_0x00d1
        L_0x00b3:
            r2 = move-exception
            r1 = r0
            r3 = r1
        L_0x00b6:
            java.lang.Class r4 = r9.getClass()     // Catch:{ all -> 0x00d0 }
            r5 = 3
            lib.android.paypal.com.magnessdk.b.a.a(r4, r5, r2)     // Catch:{ all -> 0x00d0 }
            lib.android.paypal.com.magnessdk.c$h$c r2 = lib.android.paypal.com.magnessdk.c$h$c.HTTP_STATUS_FAILED     // Catch:{ all -> 0x00d0 }
            int r2 = r2.a()     // Catch:{ all -> 0x00d0 }
            lib.android.paypal.com.magnessdk.f.a(r10, r3)
            lib.android.paypal.com.magnessdk.f.a(r10, r0)
            if (r1 == 0) goto L_0x00cf
            r1.disconnect()
        L_0x00cf:
            return r2
        L_0x00d0:
            r2 = move-exception
        L_0x00d1:
            lib.android.paypal.com.magnessdk.f.a(r10, r3)
            lib.android.paypal.com.magnessdk.f.a(r10, r0)
            if (r1 == 0) goto L_0x00dc
            r1.disconnect()
        L_0x00dc:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.base.a.execute(byte[]):int");
    }

    public String getPayPalDebugId() {
        return this.f6127c;
    }

    public byte[] getResponseContent() {
        return this.f6126b;
    }

    public void setHeader(Map<String, String> map) {
        this.f6129e = map;
    }

    public void setUri(Uri uri) {
        this.f6128d = uri;
    }
}
