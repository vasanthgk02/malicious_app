package lib.android.paypal.com.magnessdk.network.base;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class b implements MagnesNetworking {

    /* renamed from: a  reason: collision with root package name */
    public final f f6130a = new f();

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6131b;

    /* renamed from: c  reason: collision with root package name */
    public String f6132c = null;

    /* renamed from: d  reason: collision with root package name */
    public Uri f6133d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f6134e = new HashMap();

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int execute(byte[] r10) {
        /*
            r9 = this;
            java.lang.Class<lib.android.paypal.com.magnessdk.network.base.b> r0 = lib.android.paypal.com.magnessdk.network.base.b.class
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            android.net.Uri r3 = r9.f6133d     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            lib.android.paypal.com.magnessdk.c$h$a r3 = lib.android.paypal.com.magnessdk.c$h$a.HTTP_READ_TIMEOUT     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            int r3 = r3.a()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            lib.android.paypal.com.magnessdk.c$h$a r3 = lib.android.paypal.com.magnessdk.c$h$a.HTTP_CONNECT_TIMEOUT     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            int r3 = r3.a()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            lib.android.paypal.com.magnessdk.c$h$b r3 = lib.android.paypal.com.magnessdk.c$h$b.POST     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            lib.android.paypal.com.magnessdk.network.base.f r3 = r9.f6130a     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r2.setSSLSocketFactory(r3)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r3 = 1
            r2.setDoOutput(r3)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            int r3 = r10.length     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r2.setFixedLengthStreamingMode(r3)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r9.f6134e     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
        L_0x004c:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            if (r4 == 0) goto L_0x006c
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r2.setRequestProperty(r5, r4)     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            goto L_0x004c
        L_0x006c:
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ Exception -> 0x00c9, all -> 0x00c6 }
            r3.write(r10)     // Catch:{ Exception -> 0x00c4 }
            r3.flush()     // Catch:{ Exception -> 0x00c4 }
            int r10 = r2.getResponseCode()     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r4 = "correlation-id"
            java.lang.String r4 = r2.getHeaderField(r4)     // Catch:{ Exception -> 0x00c4 }
            r9.f6132c = r4     // Catch:{ Exception -> 0x00c4 }
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            if (r10 != r4) goto L_0x00b6
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c4 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ Exception -> 0x00c4 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x00c4 }
            lib.android.paypal.com.magnessdk.c$h$a r1 = lib.android.paypal.com.magnessdk.c$h$a.READ_BYTE     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            int r1 = r1.a()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r6.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        L_0x009d:
            int r7 = r4.read(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r8 = -1
            if (r7 == r8) goto L_0x00a8
            r6.write(r1, r5, r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            goto L_0x009d
        L_0x00a8:
            byte[] r1 = r6.toByteArray()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r9.f6131b = r1     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r1 = r4
            goto L_0x00ba
        L_0x00b0:
            r10 = move-exception
            r1 = r4
            goto L_0x00ee
        L_0x00b3:
            r10 = move-exception
            r1 = r4
            goto L_0x00d3
        L_0x00b6:
            byte[] r4 = new byte[r5]     // Catch:{ Exception -> 0x00c4 }
            r9.f6131b = r4     // Catch:{ Exception -> 0x00c4 }
        L_0x00ba:
            lib.android.paypal.com.magnessdk.f.a(r0, r1)
            lib.android.paypal.com.magnessdk.f.a(r0, r3)
            r2.disconnect()
            return r10
        L_0x00c4:
            r10 = move-exception
            goto L_0x00d3
        L_0x00c6:
            r10 = move-exception
            r3 = r1
            goto L_0x00ee
        L_0x00c9:
            r10 = move-exception
            r3 = r1
            goto L_0x00d3
        L_0x00cc:
            r10 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00ee
        L_0x00d0:
            r10 = move-exception
            r2 = r1
            r3 = r2
        L_0x00d3:
            java.lang.Class r4 = r9.getClass()     // Catch:{ all -> 0x00ed }
            r5 = 3
            lib.android.paypal.com.magnessdk.b.a.a(r4, r5, r10)     // Catch:{ all -> 0x00ed }
            lib.android.paypal.com.magnessdk.c$h$c r10 = lib.android.paypal.com.magnessdk.c$h$c.HTTP_STATUS_FAILED     // Catch:{ all -> 0x00ed }
            int r10 = r10.a()     // Catch:{ all -> 0x00ed }
            lib.android.paypal.com.magnessdk.f.a(r0, r1)
            lib.android.paypal.com.magnessdk.f.a(r0, r3)
            if (r2 == 0) goto L_0x00ec
            r2.disconnect()
        L_0x00ec:
            return r10
        L_0x00ed:
            r10 = move-exception
        L_0x00ee:
            lib.android.paypal.com.magnessdk.f.a(r0, r1)
            lib.android.paypal.com.magnessdk.f.a(r0, r3)
            if (r2 == 0) goto L_0x00f9
            r2.disconnect()
        L_0x00f9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.base.b.execute(byte[]):int");
    }

    public String getPayPalDebugId() {
        return this.f6132c;
    }

    public byte[] getResponseContent() {
        return this.f6131b;
    }

    public void setHeader(Map<String, String> map) {
        this.f6134e = map;
    }

    public void setUri(Uri uri) {
        this.f6133d = uri;
    }
}
