package com.cardinalcommerce.shared.cs.d;

import android.os.AsyncTask;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.io.DataOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class a extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    public String f2072a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f2073b;

    /* renamed from: c  reason: collision with root package name */
    public DataOutputStream f2074c;

    /* renamed from: d  reason: collision with root package name */
    public OutputStreamWriter f2075d;

    /* renamed from: e  reason: collision with root package name */
    public int f2076e;

    /* renamed from: f  reason: collision with root package name */
    public int f2077f;
    public HashMap<String, String> g = new HashMap<>();
    public b h;
    public byte[] i;
    public String j;

    public abstract void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar);

    public abstract void a(String str);

    public abstract void a(String str, int i2);

    public void a(String str, String str2, int i2) {
        this.f2072a = str;
        this.h = b.JSON;
        this.f2076e = i2;
        this.f2077f = i2;
        this.j = str2;
        this.g.put("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
        this.g.put("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x019b, code lost:
        if (r6 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01c9, code lost:
        if (r6 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01cd, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01ce, code lost:
        a((java.lang.Exception) r6, com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0108, code lost:
        if (r6 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013b, code lost:
        if (r6 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x016d, code lost:
        if (r6 != null) goto L_0x013d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x018f A[SYNTHETIC, Splitter:B:101:0x018f] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01af A[SYNTHETIC, Splitter:B:115:0x01af] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01bd A[SYNTHETIC, Splitter:B:121:0x01bd] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01e0 A[SYNTHETIC, Splitter:B:135:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ee A[SYNTHETIC, Splitter:B:141:0x01ee] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01fc A[SYNTHETIC, Splitter:B:147:0x01fc] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0121 A[SYNTHETIC, Splitter:B:53:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012f A[SYNTHETIC, Splitter:B:59:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0153 A[SYNTHETIC, Splitter:B:75:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0161 A[SYNTHETIC, Splitter:B:81:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0181 A[SYNTHETIC, Splitter:B:95:0x0181] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:109:0x01a1=Splitter:B:109:0x01a1, B:47:0x0113=Splitter:B:47:0x0113, B:89:0x0173=Splitter:B:89:0x0173, B:69:0x0145=Splitter:B:69:0x0145} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doInBackground(java.lang.Object[] r6) {
        /*
            r5 = this;
            java.lang.Void[] r6 = (java.lang.Void[]) r6
            java.lang.String r6 = "Accept"
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = "charset"
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.String r4 = r5.f2072a     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r3.<init>(r4)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r5.f2073b = r3     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r3 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r5.g     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r3.setRequestProperty(r0, r4)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r0 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r5.g     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r0.setRequestProperty(r6, r3)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r6 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            int r0 = r5.f2076e     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.setReadTimeout(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r6 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            int r0 = r5.f2077f     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.setConnectTimeout(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r5.g     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            boolean r6 = r6.containsKey(r1)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            if (r6 == 0) goto L_0x0060
            java.net.HttpURLConnection r6 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r5.g     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.setRequestProperty(r1, r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
        L_0x0060:
            com.cardinalcommerce.shared.cs.d.b r6 = r5.h     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            com.cardinalcommerce.shared.cs.d.b r0 = com.cardinalcommerce.shared.cs.d.b.JOSE     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            if (r6 != r0) goto L_0x007e
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r0 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.<init>(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r5.f2074c = r6     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            byte[] r0 = r5.i     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.write(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.io.DataOutputStream r6 = r5.f2074c     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.flush()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            goto L_0x0095
        L_0x007e:
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r0 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.<init>(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r5.f2075d = r6     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.String r0 = r5.j     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.write(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.io.OutputStreamWriter r6 = r5.f2075d     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.flush()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
        L_0x0095:
            java.net.HttpURLConnection r6 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            int r6 = r6.getResponseCode()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto L_0x00d9
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.net.HttpURLConnection r1 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r0.<init>(r1)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6.<init>(r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
            r0.<init>()     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
        L_0x00b4:
            java.lang.String r1 = r6.readLine()     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
            if (r1 == 0) goto L_0x00c3
            r0.append(r1)     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
            goto L_0x00b4
        L_0x00c3:
            java.lang.String r0 = r0.toString()     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
            r5.a(r0)     // Catch:{ ProtocolException -> 0x00d6, MalformedURLException -> 0x00d3, SocketTimeoutException -> 0x00d0, IOException -> 0x00ce }
            goto L_0x00e5
        L_0x00cb:
            r2 = r6
            goto L_0x01d7
        L_0x00ce:
            r0 = move-exception
            goto L_0x0113
        L_0x00d0:
            r0 = move-exception
            goto L_0x0145
        L_0x00d3:
            r0 = move-exception
            goto L_0x0173
        L_0x00d6:
            r0 = move-exception
            goto L_0x01a1
        L_0x00d9:
            java.lang.String r6 = "ACS not reachable"
            java.net.HttpURLConnection r0 = r5.f2073b     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            int r0 = r0.getResponseCode()     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r5.a(r6, r0)     // Catch:{ ProtocolException -> 0x019e, MalformedURLException -> 0x0170, SocketTimeoutException -> 0x0142, IOException -> 0x0110, all -> 0x010c }
            r6 = r2
        L_0x00e5:
            java.net.HttpURLConnection r0 = r5.f2073b
            if (r0 == 0) goto L_0x00ec
            r0.disconnect()
        L_0x00ec:
            if (r6 == 0) goto L_0x00f8
            r6.close()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f8
        L_0x00f2:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x00f8:
            java.io.OutputStreamWriter r6 = r5.f2075d
            if (r6 == 0) goto L_0x0106
            r6.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0106
        L_0x0100:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x0106:
            java.io.DataOutputStream r6 = r5.f2074c
            if (r6 == 0) goto L_0x01d3
            goto L_0x01cb
        L_0x010c:
            r6 = move-exception
            r0 = r6
            goto L_0x01d7
        L_0x0110:
            r6 = move-exception
            r0 = r6
            r6 = r2
        L_0x0113:
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION     // Catch:{ all -> 0x01d4 }
            r5.a(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.net.HttpURLConnection r0 = r5.f2073b
            if (r0 == 0) goto L_0x011f
            r0.disconnect()
        L_0x011f:
            if (r6 == 0) goto L_0x012b
            r6.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x012b
        L_0x0125:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x012b:
            java.io.OutputStreamWriter r6 = r5.f2075d
            if (r6 == 0) goto L_0x0139
            r6.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x0139
        L_0x0133:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x0139:
            java.io.DataOutputStream r6 = r5.f2074c
            if (r6 == 0) goto L_0x01d3
        L_0x013d:
            r6.close()     // Catch:{ IOException -> 0x01cd }
            goto L_0x01d3
        L_0x0142:
            r6 = move-exception
            r0 = r6
            r6 = r2
        L_0x0145:
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ all -> 0x01d4 }
            r5.a(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.net.HttpURLConnection r0 = r5.f2073b
            if (r0 == 0) goto L_0x0151
            r0.disconnect()
        L_0x0151:
            if (r6 == 0) goto L_0x015d
            r6.close()     // Catch:{ IOException -> 0x0157 }
            goto L_0x015d
        L_0x0157:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x015d:
            java.io.OutputStreamWriter r6 = r5.f2075d
            if (r6 == 0) goto L_0x016b
            r6.close()     // Catch:{ IOException -> 0x0165 }
            goto L_0x016b
        L_0x0165:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x016b:
            java.io.DataOutputStream r6 = r5.f2074c
            if (r6 == 0) goto L_0x01d3
            goto L_0x01cb
        L_0x0170:
            r6 = move-exception
            r0 = r6
            r6 = r2
        L_0x0173:
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.MALFORMED_URL_EXCEPTION     // Catch:{ all -> 0x01d4 }
            r5.a(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.net.HttpURLConnection r0 = r5.f2073b
            if (r0 == 0) goto L_0x017f
            r0.disconnect()
        L_0x017f:
            if (r6 == 0) goto L_0x018b
            r6.close()     // Catch:{ IOException -> 0x0185 }
            goto L_0x018b
        L_0x0185:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x018b:
            java.io.OutputStreamWriter r6 = r5.f2075d
            if (r6 == 0) goto L_0x0199
            r6.close()     // Catch:{ IOException -> 0x0193 }
            goto L_0x0199
        L_0x0193:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x0199:
            java.io.DataOutputStream r6 = r5.f2074c
            if (r6 == 0) goto L_0x01d3
            goto L_0x013d
        L_0x019e:
            r6 = move-exception
            r0 = r6
            r6 = r2
        L_0x01a1:
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.PROTOCOL_EXCEPTION     // Catch:{ all -> 0x01d4 }
            r5.a(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.net.HttpURLConnection r0 = r5.f2073b
            if (r0 == 0) goto L_0x01ad
            r0.disconnect()
        L_0x01ad:
            if (r6 == 0) goto L_0x01b9
            r6.close()     // Catch:{ IOException -> 0x01b3 }
            goto L_0x01b9
        L_0x01b3:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x01b9:
            java.io.OutputStreamWriter r6 = r5.f2075d
            if (r6 == 0) goto L_0x01c7
            r6.close()     // Catch:{ IOException -> 0x01c1 }
            goto L_0x01c7
        L_0x01c1:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x01c7:
            java.io.DataOutputStream r6 = r5.f2074c
            if (r6 == 0) goto L_0x01d3
        L_0x01cb:
            goto L_0x013d
        L_0x01cd:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r0 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r0)
        L_0x01d3:
            return r2
        L_0x01d4:
            r0 = move-exception
            goto L_0x00cb
        L_0x01d7:
            java.net.HttpURLConnection r6 = r5.f2073b
            if (r6 == 0) goto L_0x01de
            r6.disconnect()
        L_0x01de:
            if (r2 == 0) goto L_0x01ea
            r2.close()     // Catch:{ IOException -> 0x01e4 }
            goto L_0x01ea
        L_0x01e4:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r1)
        L_0x01ea:
            java.io.OutputStreamWriter r6 = r5.f2075d
            if (r6 == 0) goto L_0x01f8
            r6.close()     // Catch:{ IOException -> 0x01f2 }
            goto L_0x01f8
        L_0x01f2:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r1)
        L_0x01f8:
            java.io.DataOutputStream r6 = r5.f2074c
            if (r6 == 0) goto L_0x0206
            r6.close()     // Catch:{ IOException -> 0x0200 }
            goto L_0x0206
        L_0x0200:
            r6 = move-exception
            com.cardinalcommerce.shared.cs.b.a r1 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION
            r5.a(r6, r1)
        L_0x0206:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.shared.cs.d.a.doInBackground(java.lang.Object[]):java.lang.Object");
    }
}
