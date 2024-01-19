package com.razorpay;

import android.os.AsyncTask;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class l__d$ extends AsyncTask<String, Void, K$$z$> {
    public Callback G__G_;
    public Map<String, String> Q_$2$ = new HashMap();
    public String R$$r_ = null;
    public String a_$P$ = null;

    public l__d$(Callback callback) {
        this.G__G_ = callback;
    }

    public static AsyncTask G__G_(String str, Map<String, String> map, Callback callback) {
        l__d$ l__d_ = new l__d$(callback);
        l__d_.R$$r_ = HttpGetRequest.METHOD_GET;
        l__d_.Q_$2$ = map;
        return l__d_.execute(new String[]{str});
    }

    public static AsyncTask Q_$2$(String str, String str2, Map<String, String> map, Callback callback) {
        l__d$ l__d_ = new l__d$(callback);
        l__d_.R$$r_ = RNCWebViewManager.HTTP_METHOD_POST;
        l__d_.a_$P$ = str2;
        l__d_.Q_$2$ = map;
        return l__d_.execute(new String[]{str});
    }

    public static AsyncTask R$$r_(String str, Callback callback) {
        l__d$ l__d_ = new l__d$(callback);
        l__d_.R$$r_ = HttpGetRequest.METHOD_GET;
        return l__d_.execute(new String[]{str});
    }

    /* access modifiers changed from: private */
    /* renamed from: a_$P$ */
    public K$$z$ doInBackground(String... strArr) {
        InputStream inputStream;
        K$$z$ k$$z$ = new K$$z$();
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(strArr[0]).openConnection()));
            for (Entry next : this.Q_$2$.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            httpURLConnection.setRequestMethod(this.R$$r_);
            if (this.a_$P$ != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(this.a_$P$.getBytes(StandardCharsets.UTF_8));
            }
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            k$$z$.R$$r_(responseCode);
            if (responseCode >= 400) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            k$$z$.Q_$2$(httpURLConnection.getHeaderFields());
            k$$z$.a_$P$(R$$r_(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                }
            }
        } catch (Exception e3) {
            StringBuilder sb = new StringBuilder("Input Stream: ");
            sb.append(e3.getLocalizedMessage());
            sb.toString();
            AnalyticsUtil.reportError(e3, "error", e3.getMessage());
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Throwable th) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e4) {
                    AnalyticsUtil.reportError(e4, "error", e4.getMessage());
                }
            }
            throw th;
        }
        return k$$z$;
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        K$$z$ k$$z$ = (K$$z$) obj;
        Callback callback = this.G__G_;
        if (callback != null) {
            callback.run(k$$z$);
        }
    }

    public static String R$$r_(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }
}
