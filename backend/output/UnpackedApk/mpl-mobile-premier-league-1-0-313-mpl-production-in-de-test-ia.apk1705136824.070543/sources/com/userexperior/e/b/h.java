package com.userexperior.e.b;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.userexperior.e.a.a;
import com.userexperior.e.o;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLSocketFactory;

public class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public final i f3960a;

    /* renamed from: b  reason: collision with root package name */
    public final SSLSocketFactory f3961b;

    public h() {
        this(0);
    }

    public h(byte b2) {
        this(0);
    }

    public h(char c2) {
        this.f3960a = null;
        this.f3961b = null;
    }

    public static a a(HttpURLConnection httpURLConnection, boolean z) {
        InputStream inputStream;
        a aVar = new a();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        if (z) {
            try {
                aVar.f3925b = new GZIPInputStream(inputStream);
            } catch (IOException unused2) {
            }
            aVar.f3926c = httpURLConnection.getContentLength();
            aVar.f3927d = httpURLConnection.getContentEncoding();
            aVar.f3928e = httpURLConnection.getContentType();
            return aVar;
        }
        aVar.f3925b = inputStream;
        aVar.f3926c = httpURLConnection.getContentLength();
        aVar.f3927d = httpURLConnection.getContentEncoding();
        aVar.f3928e = httpURLConnection.getContentType();
        return aVar;
    }

    public static void a(HttpURLConnection httpURLConnection, o<?> oVar) throws IOException, com.userexperior.e.a {
        byte[] g = oVar.g();
        if (g != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", oVar.f());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(g);
            dataOutputStream.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a2, code lost:
        r0.setRequestMethod(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a9, code lost:
        a(r0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00af, code lost:
        r0.setRequestMethod(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d7, code lost:
        r10 = r0.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00dc, code lost:
        if (r10 == -1) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00de, code lost:
        r1 = new com.userexperior.e.a.b(r0.getResponseCode(), r0.getResponseMessage());
        r4 = r0.getHeaderFields().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fb, code lost:
        if (r4.hasNext() == false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fd, code lost:
        r5 = (java.util.Map.Entry) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0107, code lost:
        if (r5.getKey() == null) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        r1.f3931c.put((java.lang.String) r5.getKey(), (java.lang.String) ((java.util.List) r5.getValue()).get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0124, code lost:
        if (r9.f4017f == 4) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0128, code lost:
        if (100 > r10) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012c, code lost:
        if (r10 < 200) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0130, code lost:
        if (r10 == 204) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0134, code lost:
        if (r10 == 304) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0136, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0138, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0139, code lost:
        if (r9 == false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013b, code lost:
        r9 = r1.f3931c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013d, code lost:
        if (r9 == null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013f, code lost:
        r9 = r9.get("Content-Encoding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0147, code lost:
        if (r9 == null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014f, code lost:
        if (r9.contains("gzip") == false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0151, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0152, code lost:
        r1.f3930b = a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0158, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0160, code lost:
        throw new java.io.IOException("Could not retrieve response code from HttpUrlConnection.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.userexperior.e.a.b a(com.userexperior.e.o<?> r9, java.util.Map<java.lang.String, java.lang.String> r10) throws java.io.IOException, com.userexperior.e.a {
        /*
            r8 = this;
            java.lang.String r0 = r9.c()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r2 = r9.d()
            r1.putAll(r2)
            r1.putAll(r10)
            com.userexperior.e.b.i r10 = r8.f3960a
            if (r10 == 0) goto L_0x002f
            java.lang.String r10 = r10.a()
            if (r10 == 0) goto L_0x001f
            r0 = r10
            goto L_0x002f
        L_0x001f:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "URL blocked by rewriter: "
            java.lang.String r10 = r0.concat(r10)
            r9.<init>(r10)
            throw r9
        L_0x002f:
            java.net.URL r10 = new java.net.URL
            r10.<init>(r0)
            java.net.HttpURLConnection r0 = r8.a(r10)
            int r2 = r9.h()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r3 = 1
            r0.setDoInput(r3)
            java.lang.String r10 = r10.getProtocol()
            java.lang.String r4 = "https"
            boolean r10 = r4.equals(r10)
            if (r10 == 0) goto L_0x0064
            javax.net.ssl.SSLSocketFactory r10 = r8.f3961b
            if (r10 == 0) goto L_0x0064
            boolean r4 = r0 instanceof javax.net.ssl.HttpsURLConnection
            if (r4 == 0) goto L_0x0064
            r4 = r0
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4
            r4.setSSLSocketFactory(r10)
        L_0x0064:
            java.util.Set r10 = r1.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x006c:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x0082
            java.lang.Object r4 = r10.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r0.addRequestProperty(r4, r5)
            goto L_0x006c
        L_0x0082:
            int r10 = r9.f4017f
            java.lang.String r1 = "POST"
            switch(r10) {
                case -1: goto L_0x00b3;
                case 0: goto L_0x00ad;
                case 1: goto L_0x00a6;
                case 2: goto L_0x00a0;
                case 3: goto L_0x009d;
                case 4: goto L_0x009a;
                case 5: goto L_0x0097;
                case 6: goto L_0x0094;
                case 7: goto L_0x0091;
                default: goto L_0x0089;
            }
        L_0x0089:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Unknown method type."
            r9.<init>(r10)
            throw r9
        L_0x0091:
            java.lang.String r10 = "PATCH"
            goto L_0x00a2
        L_0x0094:
            java.lang.String r10 = "TRACE"
            goto L_0x00af
        L_0x0097:
            java.lang.String r10 = "OPTIONS"
            goto L_0x00af
        L_0x009a:
            java.lang.String r10 = "HEAD"
            goto L_0x00af
        L_0x009d:
            java.lang.String r10 = "DELETE"
            goto L_0x00af
        L_0x00a0:
            java.lang.String r10 = "PUT"
        L_0x00a2:
            r0.setRequestMethod(r10)
            goto L_0x00a9
        L_0x00a6:
            r0.setRequestMethod(r1)
        L_0x00a9:
            a(r0, r9)
            goto L_0x00d7
        L_0x00ad:
            java.lang.String r10 = "GET"
        L_0x00af:
            r0.setRequestMethod(r10)
            goto L_0x00d7
        L_0x00b3:
            byte[] r10 = r9.e()
            if (r10 == 0) goto L_0x00d7
            r0.setDoOutput(r3)
            r0.setRequestMethod(r1)
            java.lang.String r1 = r9.f()
            java.lang.String r4 = "Content-Type"
            r0.addRequestProperty(r4, r1)
            java.io.DataOutputStream r1 = new java.io.DataOutputStream
            java.io.OutputStream r4 = r0.getOutputStream()
            r1.<init>(r4)
            r1.write(r10)
            r1.close()
        L_0x00d7:
            int r10 = r0.getResponseCode()
            r1 = -1
            if (r10 == r1) goto L_0x0159
            com.userexperior.e.a.b r1 = new com.userexperior.e.a.b
            int r4 = r0.getResponseCode()
            java.lang.String r5 = r0.getResponseMessage()
            r1.<init>(r4, r5)
            java.util.Map r4 = r0.getHeaderFields()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00f7:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0121
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            if (r6 == 0) goto L_0x00f7
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            java.util.Map<java.lang.String, java.lang.String> r7 = r1.f3931c
            r7.put(r6, r5)
            goto L_0x00f7
        L_0x0121:
            int r9 = r9.f4017f
            r4 = 4
            if (r9 == r4) goto L_0x0138
            r9 = 100
            if (r9 > r10) goto L_0x012e
            r9 = 200(0xc8, float:2.8E-43)
            if (r10 < r9) goto L_0x0138
        L_0x012e:
            r9 = 204(0xcc, float:2.86E-43)
            if (r10 == r9) goto L_0x0138
            r9 = 304(0x130, float:4.26E-43)
            if (r10 == r9) goto L_0x0138
            r9 = 1
            goto L_0x0139
        L_0x0138:
            r9 = 0
        L_0x0139:
            if (r9 == 0) goto L_0x0158
            java.util.Map<java.lang.String, java.lang.String> r9 = r1.f3931c
            if (r9 == 0) goto L_0x0152
            java.lang.String r10 = "Content-Encoding"
            java.lang.Object r9 = r9.get(r10)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0152
            java.lang.String r10 = "gzip"
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x0152
            r2 = 1
        L_0x0152:
            com.userexperior.e.a.a r9 = a(r0, r2)
            r1.f3930b = r9
        L_0x0158:
            return r1
        L_0x0159:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Could not retrieve response code from HttpUrlConnection."
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.b.h.a(com.userexperior.e.o, java.util.Map):com.userexperior.e.a.b");
    }

    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }
}
