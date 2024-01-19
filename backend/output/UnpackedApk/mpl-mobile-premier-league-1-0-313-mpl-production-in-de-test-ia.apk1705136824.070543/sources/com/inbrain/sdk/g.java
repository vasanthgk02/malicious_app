package com.inbrain.sdk;

import android.os.AsyncTask;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class g extends AsyncTask<String, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public final b f1816a;

    public g(b bVar) {
        this.f1816a = bVar;
    }

    public final Object doInBackground(Object[] objArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(((String[]) objArr)[0]).openConnection()));
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setRequestMethod(HttpGetRequest.METHOD_GET);
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
                this.f1816a.a((Exception) new IllegalStateException(httpURLConnection.getResponseMessage()));
                return null;
            }
        } catch (Exception e2) {
            this.f1816a.a(e2);
            return null;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        super.onPostExecute(str);
        if (str != null) {
            this.f1816a.a(str);
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
