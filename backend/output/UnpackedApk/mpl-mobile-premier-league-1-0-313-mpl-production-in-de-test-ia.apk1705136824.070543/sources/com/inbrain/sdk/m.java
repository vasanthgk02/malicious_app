package com.inbrain.sdk;

import android.os.AsyncTask;
import android.text.TextUtils;

public final class m extends AsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public final b f1829a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1830b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1831c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1832d;

    public m(b bVar, boolean z, String str, String str2) {
        this.f1829a = bVar;
        this.f1830b = z;
        this.f1831c = str;
        this.f1832d = str2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|23|(2:24|(1:26)(1:35))|27|(2:29|38)|30|31|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00fe */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a2 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c7 A[SYNTHETIC, Splitter:B:22:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doInBackground(java.lang.Object[] r8) {
        /*
            r7 = this;
            java.lang.String r8 = "UTF-8"
            java.lang.String r0 = ""
            java.lang.String r1 = r7.f1831c     // Catch:{ UnsupportedEncodingException -> 0x0013 }
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r8)     // Catch:{ UnsupportedEncodingException -> 0x0013 }
            java.lang.String r2 = r7.f1832d     // Catch:{ UnsupportedEncodingException -> 0x0011 }
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r8)     // Catch:{ UnsupportedEncodingException -> 0x0011 }
            goto L_0x001a
        L_0x0011:
            r2 = move-exception
            goto L_0x0016
        L_0x0013:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0016:
            r2.printStackTrace()
            r2 = r0
        L_0x001a:
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r1
            r1 = 1
            r3[r1] = r2
            r2 = 2
            java.lang.String r5 = "inbrain-api:integration"
            r3[r2] = r5
            r2 = 3
            java.lang.String r5 = "client_credentials"
            r3[r2] = r5
            java.lang.String r2 = "client_id=%s&client_secret=%s&scope=%s&grant_type=%s"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r8)     // Catch:{ Exception -> 0x010d }
            byte[] r3 = r2.getBytes(r3)     // Catch:{ Exception -> 0x010d }
            int r3 = r3.length     // Catch:{ Exception -> 0x010d }
            boolean r5 = r7.f1830b     // Catch:{ Exception -> 0x010d }
            if (r5 == 0) goto L_0x0048
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x010d }
            java.lang.String r6 = "https://inbrain-auth-qa.azurewebsites.net/connect/token"
            r5.<init>(r6)     // Catch:{ Exception -> 0x010d }
            goto L_0x004f
        L_0x0048:
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x010d }
            java.lang.String r6 = "https://auth.surveyb.in/connect/token"
            r5.<init>(r6)     // Catch:{ Exception -> 0x010d }
        L_0x004f:
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x010d }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ Exception -> 0x010d }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ Exception -> 0x010d }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x010d }
            r5.setDoOutput(r1)     // Catch:{ Exception -> 0x010d }
            r5.setInstanceFollowRedirects(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "POST"
            r5.setRequestMethod(r1)     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "Content-Type"
            java.lang.String r6 = "application/x-www-form-urlencoded"
            r5.setRequestProperty(r1, r6)     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "charset"
            java.lang.String r6 = "utf-8"
            r5.setRequestProperty(r1, r6)     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "Content-Length"
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ Exception -> 0x010d }
            r5.setRequestProperty(r1, r3)     // Catch:{ Exception -> 0x010d }
            r5.setUseCaches(r4)     // Catch:{ Exception -> 0x010d }
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch:{ Exception -> 0x010d }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x010d }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x010d }
            r4.<init>(r1, r8)     // Catch:{ Exception -> 0x010d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x010d }
            r3.write(r2)     // Catch:{ Exception -> 0x010d }
            r3.flush()     // Catch:{ Exception -> 0x010d }
            r3.close()     // Catch:{ Exception -> 0x010d }
            r1.close()     // Catch:{ Exception -> 0x010d }
            int r8 = r5.getResponseCode()     // Catch:{ Exception -> 0x010d }
            r1 = 200(0xc8, float:2.8E-43)
            if (r8 != r1) goto L_0x00c7
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x010d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x010d }
            java.io.InputStream r2 = r5.getInputStream()     // Catch:{ Exception -> 0x010d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x010d }
            r8.<init>(r1)     // Catch:{ Exception -> 0x010d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            r1.<init>()     // Catch:{ Exception -> 0x010d }
        L_0x00b5:
            java.lang.String r2 = r8.readLine()     // Catch:{ Exception -> 0x010d }
            if (r2 == 0) goto L_0x00bf
            r1.append(r2)     // Catch:{ Exception -> 0x010d }
            goto L_0x00b5
        L_0x00bf:
            r8.close()     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x010d }
            goto L_0x0113
        L_0x00c7:
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00fe }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00fe }
            java.io.InputStream r2 = r5.getErrorStream()     // Catch:{ Exception -> 0x00fe }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00fe }
            r8.<init>(r1)     // Catch:{ Exception -> 0x00fe }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fe }
            r1.<init>()     // Catch:{ Exception -> 0x00fe }
        L_0x00da:
            java.lang.String r2 = r8.readLine()     // Catch:{ Exception -> 0x00fe }
            if (r2 == 0) goto L_0x00e4
            r1.append(r2)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00da
        L_0x00e4:
            r8.close()     // Catch:{ Exception -> 0x00fe }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = "{\"error\":\"invalid_client\"}"
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x00fe }
            if (r8 == 0) goto L_0x00fe
            com.inbrain.sdk.b r8 = r7.f1829a     // Catch:{ Exception -> 0x00fe }
            com.inbrain.sdk.h r1 = new com.inbrain.sdk.h     // Catch:{ Exception -> 0x00fe }
            r1.<init>()     // Catch:{ Exception -> 0x00fe }
            r8.a(r1)     // Catch:{ Exception -> 0x00fe }
            goto L_0x0113
        L_0x00fe:
            com.inbrain.sdk.b r8 = r7.f1829a     // Catch:{ Exception -> 0x010d }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x010d }
            java.lang.String r2 = r5.getResponseMessage()     // Catch:{ Exception -> 0x010d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x010d }
            r8.a(r1)     // Catch:{ Exception -> 0x010d }
            goto L_0x0113
        L_0x010d:
            r8 = move-exception
            com.inbrain.sdk.b r1 = r7.f1829a
            r1.a(r8)
        L_0x0113:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inbrain.sdk.m.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        super.onPostExecute(str);
        if (!TextUtils.isEmpty(str)) {
            this.f1829a.a(str);
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
