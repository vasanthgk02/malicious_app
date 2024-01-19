package com.inbrain.sdk;

import android.os.AsyncTask;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class c extends AsyncTask<String, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public final b f1810a;

    public c(b bVar) {
        this.f1810a = bVar;
    }

    public final Object doInBackground(Object[] objArr) {
        b bVar;
        Exception illegalStateException;
        String[] strArr = (String[]) objArr;
        boolean z = false;
        String str = strArr[0];
        String str2 = strArr[1];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setRequestMethod(HttpGetRequest.METHOD_GET);
            httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(String.valueOf(str2)));
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        bufferedReader.close();
                        return stringBuffer.toString();
                    }
                }
            } else {
                if (httpURLConnection.getResponseCode() == 401) {
                    z = true;
                }
                if (httpURLConnection.getResponseMessage().equals("Unauthorized") && z) {
                    bVar = this.f1810a;
                    illegalStateException = new l(httpURLConnection.getResponseMessage());
                } else {
                    bVar = this.f1810a;
                    illegalStateException = new IllegalStateException(httpURLConnection.getResponseMessage());
                }
                bVar.a(illegalStateException);
                return null;
            }
        } catch (Exception e2) {
            this.f1810a.a(e2);
            return null;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        super.onPostExecute(str);
        if (str != null) {
            this.f1810a.a(str);
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
