package com.shield.android.e;

import android.os.Process;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mpl.androidapp.Featurestag;
import com.shield.android.ShieldException;
import com.shield.android.internal.j;
import in.juspay.hypersdk.core.InflateView;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static String f1583b = "";

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f1584a;

    public class a extends b {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f1585d;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public a(HttpURLConnection httpURLConnection, InputStream inputStream, OutputStream outputStream, e eVar) {
            // this.f1585d = eVar;
            super(httpURLConnection, null, outputStream);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:20|21|22|23|(3:25|26|(2:28|29))(3:30|31|(2:33|34))|35|36|37|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            r0 = r9.f1586e.a(r9.f1563a.getErrorStream());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x010c */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[SYNTHETIC, Splitter:B:17:0x0043] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00ff A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r9 = this;
                r0 = 0
                java.net.HttpURLConnection r1 = r9.f1563a     // Catch:{ Exception -> 0x0039 }
                javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x0039 }
                java.security.cert.Certificate[] r1 = r1.getServerCertificates()     // Catch:{ Exception -> 0x0039 }
                if (r1 == 0) goto L_0x0039
                int r2 = r1.length     // Catch:{ Exception -> 0x0039 }
                if (r2 <= 0) goto L_0x0039
                r1 = r1[r0]     // Catch:{ Exception -> 0x0039 }
                java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1     // Catch:{ Exception -> 0x0039 }
                javax.security.auth.x500.X500Principal r2 = r1.getIssuerX500Principal()     // Catch:{ Exception -> 0x0039 }
                if (r2 == 0) goto L_0x0039
                javax.security.auth.x500.X500Principal r1 = r1.getIssuerX500Principal()     // Catch:{ Exception -> 0x0039 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0039 }
                int r2 = r1.length()     // Catch:{ Exception -> 0x0039 }
                if (r2 <= 0) goto L_0x0039
                java.lang.String r2 = com.shield.android.e.g.f1583b     // Catch:{ Exception -> 0x0039 }
                boolean r2 = java.util.Objects.equals(r2, r1)     // Catch:{ Exception -> 0x0039 }
                if (r2 != 0) goto L_0x0039
                com.shield.android.e.g.f1583b = r1     // Catch:{ Exception -> 0x0039 }
                com.shield.android.Shield r1 = com.shield.android.Shield.getInstance()     // Catch:{ Exception -> 0x0039 }
                java.lang.String r2 = "certificate_change_detected"
                r1.sendDeviceSignature(r2)     // Catch:{ Exception -> 0x0039 }
            L_0x0039:
                java.net.HttpURLConnection r1 = r9.f1563a     // Catch:{ all -> 0x00f1 }
                int r1 = r1.getResponseCode()     // Catch:{ all -> 0x00f1 }
                r2 = 300(0x12c, float:4.2E-43)
                if (r1 >= r2) goto L_0x00ff
                com.shield.android.e.g r1 = com.shield.android.e.g.this     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.net.HttpURLConnection r2 = r9.f1563a     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.String r1 = r1.a(r2)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.net.HttpURLConnection r2 = r9.f1563a     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.String r3 = "digest-required"
                java.lang.String r2 = r2.getHeaderField(r3)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                boolean r2 = java.lang.Boolean.parseBoolean(r2)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                if (r2 == 0) goto L_0x00e1
                java.net.HttpURLConnection r2 = r9.f1563a     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.String r3 = "message-digest"
                java.lang.String r2 = r2.getHeaderField(r3)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                r3.<init>(r1)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                org.json.JSONObject r3 = com.google.android.material.resources.TextAppearanceConfig.a(r3)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r4 = "9ce44f88a25272b6d9cbb430ebbcfcf1"
                java.lang.String r3 = com.shield.android.e.d.a(r3, r4)     // Catch:{ Exception -> 0x00c7 }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c7 }
                r4.<init>(r1)     // Catch:{ Exception -> 0x00c7 }
                boolean r5 = r3.equals(r2)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r6 = "is_payload_tampered"
                java.lang.String r7 = "result"
                if (r5 != 0) goto L_0x0099
                boolean r5 = r4.has(r7)     // Catch:{ Exception -> 0x00c7 }
                if (r5 == 0) goto L_0x00a9
                org.json.JSONObject r5 = r4.getJSONObject(r7)     // Catch:{ Exception -> 0x00a9 }
                r8 = 1
                r5.put(r6, r8)     // Catch:{ Exception -> 0x00a9 }
                r4.put(r7, r5)     // Catch:{ Exception -> 0x00a9 }
                goto L_0x00a9
            L_0x0099:
                boolean r5 = r4.has(r7)     // Catch:{ Exception -> 0x00c7 }
                if (r5 == 0) goto L_0x00a9
                org.json.JSONObject r5 = r4.getJSONObject(r7)     // Catch:{ Exception -> 0x00a9 }
                r5.put(r6, r0)     // Catch:{ Exception -> 0x00a9 }
                r4.put(r7, r5)     // Catch:{ Exception -> 0x00a9 }
            L_0x00a9:
                java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00c7 }
                com.shield.android.internal.f r4 = com.shield.android.internal.f.a()     // Catch:{ Exception -> 0x00c7 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7 }
                r5.<init>()     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r6 = "flatten signature: "
                r5.append(r6)     // Catch:{ Exception -> 0x00c7 }
                r5.append(r3)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00c7 }
                java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00c7 }
                r4.b(r3, r5)     // Catch:{ Exception -> 0x00c7 }
            L_0x00c7:
                com.shield.android.internal.f r3 = com.shield.android.internal.f.a()     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                r4.<init>()     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.String r5 = "messageDigest: "
                r4.append(r5)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                r4.append(r2)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                r3.b(r2, r0)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
            L_0x00e1:
                com.shield.android.e.e r0 = r9.f1585d     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                r0.a(r1)     // Catch:{ IOException -> 0x00f9, Exception -> 0x00f3 }
                java.net.HttpURLConnection r0 = r9.f1563a
                r0.disconnect()
                java.io.OutputStream r0 = r9.f1565c
                r0.close()
                return
            L_0x00f1:
                r0 = move-exception
                goto L_0x013f
            L_0x00f3:
                r0 = move-exception
                com.shield.android.ShieldException r0 = com.shield.android.ShieldException.unexpectedError(r0)     // Catch:{ all -> 0x00f1 }
                throw r0     // Catch:{ all -> 0x00f1 }
            L_0x00f9:
                r0 = move-exception
                com.shield.android.ShieldException r0 = com.shield.android.ShieldException.networkError(r0)     // Catch:{ all -> 0x00f1 }
                throw r0     // Catch:{ all -> 0x00f1 }
            L_0x00ff:
                com.shield.android.e.g r0 = com.shield.android.e.g.this     // Catch:{ IOException -> 0x010c }
                java.net.HttpURLConnection r2 = r9.f1563a     // Catch:{ IOException -> 0x010c }
                java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x010c }
                java.lang.String r0 = r0.a(r2)     // Catch:{ IOException -> 0x010c }
                goto L_0x0118
            L_0x010c:
                com.shield.android.e.g r0 = com.shield.android.e.g.this     // Catch:{ all -> 0x00f1 }
                java.net.HttpURLConnection r2 = r9.f1563a     // Catch:{ all -> 0x00f1 }
                java.io.InputStream r2 = r2.getErrorStream()     // Catch:{ all -> 0x00f1 }
                java.lang.String r0 = r0.a(r2)     // Catch:{ all -> 0x00f1 }
            L_0x0118:
                com.shield.android.e.g r2 = com.shield.android.e.g.this     // Catch:{ all -> 0x00f1 }
                com.shield.android.e.e r3 = r9.f1585d     // Catch:{ all -> 0x00f1 }
                java.lang.String r2 = r2.d(r3)     // Catch:{ all -> 0x00f1 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
                r3.<init>()     // Catch:{ all -> 0x00f1 }
                r3.append(r1)     // Catch:{ all -> 0x00f1 }
                java.lang.String r4 = ": "
                r3.append(r4)     // Catch:{ all -> 0x00f1 }
                java.net.HttpURLConnection r4 = r9.f1563a     // Catch:{ all -> 0x00f1 }
                java.lang.String r4 = r4.getResponseMessage()     // Catch:{ all -> 0x00f1 }
                r3.append(r4)     // Catch:{ all -> 0x00f1 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f1 }
                com.shield.android.ShieldException r0 = com.shield.android.ShieldException.httpError(r2, r1, r3, r0)     // Catch:{ all -> 0x00f1 }
                throw r0     // Catch:{ all -> 0x00f1 }
            L_0x013f:
                java.net.HttpURLConnection r1 = r9.f1563a
                r1.disconnect()
                java.io.OutputStream r1 = r9.f1565c
                r1.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shield.android.e.g.a.close():void");
        }
    }

    public class b extends b {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f1587d;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public b(HttpURLConnection httpURLConnection, InputStream inputStream, OutputStream outputStream, e eVar) {
            // this.f1587d = eVar;
            super(httpURLConnection, inputStream, null);
        }

        public void close() throws IOException {
            try {
                int responseCode = this.f1563a.getResponseCode();
                if (responseCode < 300) {
                    this.f1587d.a(g.this.a(this.f1563a.getInputStream()));
                    this.f1563a.disconnect();
                    this.f1564b.close();
                    return;
                }
                com.shield.android.internal.f a2 = com.shield.android.internal.f.a();
                a2.a("shield error: " + g.this.d(this.f1587d), new Object[0]);
                String d2 = g.this.d(this.f1587d);
                String responseMessage = this.f1563a.getResponseMessage();
                throw ShieldException.httpError(d2, responseCode, responseMessage, "Something went wrong. HTTP CODE:" + responseCode);
            } catch (IOException e2) {
                throw ShieldException.networkError(e2);
            } catch (Exception e3) {
                throw ShieldException.unexpectedError(e3);
            } catch (Throwable th) {
                this.f1563a.disconnect();
                this.f1564b.close();
                throw th;
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1589a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        static {
            /*
                com.shield.android.e.e$a[] r0 = com.shield.android.e.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1589a = r0
                com.shield.android.e.e$a r1 = com.shield.android.e.e.a.POST     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f1589a     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.shield.android.e.e$a r1 = com.shield.android.e.e.a.PUT     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = f1589a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.shield.android.e.e$a r1 = com.shield.android.e.e.a.GET     // Catch:{ NoSuchFieldError -> 0x001d }
                r1 = 0
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shield.android.e.g.c.<clinit>():void");
        }
    }

    public static class d implements ThreadFactory {
        public d(a aVar) {
        }

        public Thread newThread(Runnable runnable) {
            return new f(runnable);
        }
    }

    public static class e extends ThreadPoolExecutor {
        public e() {
            super(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(null));
        }
    }

    public static class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicInteger f1590a = new AtomicInteger(1);

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public f(Runnable runnable) {
            // StringBuilder outline73 = GeneratedOutlineSupport.outline73(Featurestag.SHIELD);
            // outline73.append(f1590a.getAndIncrement());
            super(runnable, outline73.toString());
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.shield.android.e.g$g  reason: collision with other inner class name */
    public enum C0020g {
        PENDING,
        FINISHED
    }

    public g(ExecutorService executorService) {
        this.f1584a = executorService;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(e eVar) {
        try {
            g(eVar);
        } catch (ShieldException e2) {
            eVar.a(e2);
        } catch (IOException e3) {
            eVar.a(ShieldException.networkError(e3));
        } catch (Exception e4) {
            eVar.a(ShieldException.unexpectedError(e4));
        }
    }

    public void a(e eVar, f fVar) {
        fVar.a(C0020g.PENDING);
        try {
            this.f1584a.submit(new Runnable(eVar, fVar) {
                public final /* synthetic */ e f$1;
                public final /* synthetic */ f f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    g.this.b(this.f$1, this.f$2);
                }
            });
        } catch (Exception e2) {
            eVar.a(ShieldException.unexpectedError(e2));
            fVar.a(C0020g.FINISHED);
        }
    }

    public final b b(HttpURLConnection httpURLConnection, e eVar) throws Exception {
        byte[] bArr;
        String str;
        Map<String, Object> d2 = eVar.d();
        if (eVar.e() == com.shield.android.e.e.b.JSON) {
            JSONObject jSONObject = new JSONObject();
            for (Entry next : d2.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            bArr = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        } else if (eVar.e() != com.shield.android.e.e.b.TEXT || d2.get("data") == null) {
            StringBuilder sb = new StringBuilder();
            for (Entry next2 : d2.entrySet()) {
                if (next2.getValue() instanceof String) {
                    str = (String) next2.getValue();
                } else {
                    str = String.valueOf(next2.getValue());
                }
                if (!j.a((CharSequence) str)) {
                    if (sb.length() != 0) {
                        sb.append('&');
                    }
                    sb.append(URLEncoder.encode((String) next2.getKey(), "UTF-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                }
            }
            bArr = sb.toString().getBytes(StandardCharsets.UTF_8);
        } else {
            bArr = d2.get("data").toString().getBytes(StandardCharsets.UTF_8);
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (TextUtils.equals("gzip", httpURLConnection.getRequestProperty("Accept-Encoding"))) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        }
        outputStream.write(bArr);
        a aVar = new a(httpURLConnection, null, outputStream, eVar);
        return aVar;
    }

    public final String d(e eVar) {
        String str;
        Map<String, Object> d2 = eVar.d();
        if (eVar.a() == null || eVar.a().length() <= 0) {
            str = eVar.g();
        } else {
            str = eVar.a() + eVar.g();
        }
        if (eVar.b() == com.shield.android.e.e.a.POST || d2 == null || d2.entrySet().size() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline50(str, ColorPropConverter.PREFIX_ATTR));
        for (Entry next : d2.entrySet()) {
            Object value = next.getValue();
            if (!(value instanceof String) || !j.a((CharSequence) value)) {
                if (sb.length() != str.length() + 1) {
                    sb.append('&');
                }
                sb.append((String) next.getKey());
                sb.append(InflateView.SETTER_EQUALS);
                sb.append(next.getValue());
            }
        }
        return sb.toString();
    }

    public final HttpURLConnection f(e eVar) throws Exception {
        String d2 = d(eVar);
        if (!j.a((CharSequence) d2)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(d2).openConnection()));
            httpURLConnection.setRequestMethod(eVar.b().toString());
            httpURLConnection.setRequestProperty("Api-Version", String.valueOf(1));
            com.shield.android.e.e.a b2 = eVar.b();
            com.shield.android.e.e.a aVar = com.shield.android.e.e.a.POST;
            if (b2 == aVar) {
                httpURLConnection.setRequestProperty("Content-Type", eVar.e().f1582a);
            } else {
                httpURLConnection.setRequestProperty("Accept", "text/plain");
            }
            httpURLConnection.setRequestProperty("Api-Req-Time", String.valueOf(System.currentTimeMillis()));
            httpURLConnection.setRequestProperty("Site-Id", eVar.f());
            httpURLConnection.setRequestProperty("X-Endpoint-Version", eVar.h());
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setDoInput(true);
            if (eVar.b() == aVar) {
                httpURLConnection.setDoOutput(true);
            }
            HashMap<String, String> c2 = eVar.c();
            if (c2 != null && c2.size() > 0) {
                for (Entry next : c2.entrySet()) {
                    if (!((String) next.getKey()).equals("Accept-Encoding")) {
                        httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
            return httpURLConnection;
        }
        throw new IllegalArgumentException("url must not be null or empty");
    }

    public final void g(e eVar) throws Exception {
        HttpURLConnection f2 = f(eVar);
        int i = c.f1589a[eVar.b().ordinal()];
        b bVar = 0;
        if (i == 1 || i == 2) {
            bVar = b(f2, eVar);
        } else if (i == 3) {
            try {
                InputStream inputStream = f2.getInputStream();
                if (inputStream != null) {
                    b bVar2 = new b(f2, inputStream, null, eVar);
                    bVar = bVar2;
                }
            } catch (Exception e2) {
                InputStream errorStream = f2.getErrorStream();
                if (errorStream != null) {
                    throw ShieldException.httpError(d(eVar), f2.getResponseCode(), f2.getResponseMessage(), a(errorStream));
                }
                throw ShieldException.unexpectedError(e2);
            }
        }
        if (bVar != 0) {
            bVar.close();
        }
    }

    public final String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    public void b(e eVar) {
        this.f1584a.submit(new Runnable(eVar) {
            public final /* synthetic */ e f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                g.this.e(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(e eVar, f fVar) {
        try {
            g(eVar);
        } catch (ShieldException e2) {
            eVar.a(e2);
        } catch (IOException e3) {
            eVar.a(ShieldException.networkError(e3));
        } catch (Exception e4) {
            eVar.a(ShieldException.unexpectedError(e4));
        } catch (Throwable th) {
            fVar.a(C0020g.FINISHED);
            throw th;
        }
        fVar.a(C0020g.FINISHED);
    }
}
