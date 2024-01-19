package com.inbrain.sdk;

import android.os.AsyncTask;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class d extends AsyncTask<String, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public final b f1811a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1812b = false;

    /* renamed from: c  reason: collision with root package name */
    public Exception f1813c;

    public d(b bVar) {
        this.f1811a = bVar;
    }

    public final Object doInBackground(Object[] objArr) {
        String[] strArr = (String[]) objArr;
        boolean z = false;
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
            httpURLConnection.setRequestProperty("Authorization", "Bearer ".concat(String.valueOf(str2)));
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(str3);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        bufferedReader.close();
                        this.f1812b = true;
                        return sb.toString();
                    }
                }
            } else {
                if (httpURLConnection.getResponseCode() == 401) {
                    z = true;
                }
                if (!httpURLConnection.getResponseMessage().equals("Unauthorized") || !z) {
                    return httpURLConnection.getResponseMessage();
                }
                this.f1811a.a((Exception) new l(httpURLConnection.getResponseMessage()));
                return null;
            }
        } catch (Exception e2) {
            this.f1813c = e2;
            return null;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        super.onPostExecute(str);
        if (this.f1812b) {
            this.f1811a.a(str);
        } else {
            this.f1811a.a(this.f1813c);
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
