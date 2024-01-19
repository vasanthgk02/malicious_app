package com.freshchat.consumer.sdk.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.BuildConfig;
import com.freshchat.consumer.sdk.b.b;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cw;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class c {
    public int eA = 10000;
    public int eB = 45000;
    public final Context ez;
    public final String iq;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.ez = applicationContext;
        this.iq = cw.bu(applicationContext);
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static String a(d dVar) {
        try {
            return ad.a(dVar.getInputStream(), b.da);
        } catch (Exception e2) {
            q.a(e2);
            return "";
        }
    }

    public static Map<String, String> ah(String str) throws IOException {
        HashMap hashMap = new HashMap();
        if (as.a(str)) {
            hashMap.put("Content-Type", str);
        }
        return hashMap;
    }

    private d b(HttpURLConnection httpURLConnection) throws IOException {
        InputStream a2 = a(httpURLConnection);
        d dVar = new d();
        dVar.setInputStream(a2);
        dVar.setStatusCode(httpURLConnection.getResponseCode());
        dVar.a(httpURLConnection.getHeaderFields());
        return dVar;
    }

    public d a(String str, Map<String, String> map) {
        try {
            HttpURLConnection a2 = a(str, HttpGetRequest.METHOD_GET, map);
            a2.setInstanceFollowRedirects(true);
            return b(a2);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public HttpURLConnection a(String str, String str2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        if (!HttpGetRequest.METHOD_GET.equals(str2)) {
            httpURLConnection.setDoOutput(true);
            if (!map.containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            }
            httpURLConnection.setUseCaches(false);
        }
        httpURLConnection.setRequestProperty("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
        httpURLConnection.setRequestProperty("X-FC-Platform", "Android");
        httpURLConnection.setRequestProperty("X-SDK-Version-Code", String.valueOf(BuildConfig.VERSION_CODE));
        StringBuilder sb = new StringBuilder();
        sb.append("FC-Android(");
        GeneratedOutlineSupport.outline103(sb, VERSION.RELEASE, ")(", BuildConfig.VERSION_NAME, ")(");
        sb.append(Build.MODEL);
        sb.append(")(");
        sb.append(this.ez.getPackageName());
        sb.append(")(");
        sb.append(this.iq);
        sb.append(")");
        httpURLConnection.setRequestProperty("User-Agent", sb.toString());
        httpURLConnection.setRequestProperty("X-App-Package-Name", this.ez.getPackageName());
        if (k.d(map)) {
            for (String next : map.keySet()) {
                String str3 = map.get(next);
                if (as.a(str3)) {
                    httpURLConnection.setRequestProperty(next, str3);
                }
            }
        }
        httpURLConnection.setConnectTimeout(da());
        httpURLConnection.setReadTimeout(getReadTimeout());
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public d ae(String str) {
        return a(str, new HashMap());
    }

    public d af(String str) {
        try {
            return b(e(str, "PUT"));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public d ag(String str) {
        return c(str, null);
    }

    public d c(String str, String str2) {
        try {
            HttpURLConnection e2 = e(str, RNCWebViewManager.HTTP_METHOD_POST);
            OutputStream outputStream = e2.getOutputStream();
            if (as.a(str2)) {
                outputStream.write(str2.getBytes(b.da));
            }
            outputStream.flush();
            outputStream.close();
            return b(e2);
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public d d(String str, String str2) {
        try {
            HttpURLConnection e2 = e(str, "PUT");
            OutputStream outputStream = e2.getOutputStream();
            outputStream.write(str2.getBytes(b.da));
            outputStream.flush();
            outputStream.close();
            return b(e2);
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public int da() {
        return this.eA;
    }

    public HttpURLConnection e(String str, String str2) throws IOException {
        return a(str, str2, new HashMap());
    }

    public int getReadTimeout() {
        return this.eB;
    }
}
