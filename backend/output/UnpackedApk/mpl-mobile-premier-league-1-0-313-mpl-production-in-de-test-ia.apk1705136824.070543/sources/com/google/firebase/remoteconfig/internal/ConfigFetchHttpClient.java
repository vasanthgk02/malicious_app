package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.netcore.android.SMTEventParamKeys;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigFetchHttpClient {
    public static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    public final String apiKey;
    public final String appId;
    public final long connectTimeoutInSeconds;
    public final Context context;
    public final String namespace;
    public final String projectNumber;
    public final long readTimeoutInSeconds;

    public ConfigFetchHttpClient(Context context2, String str, String str2, String str3, long j, long j2) {
        this.context = context2;
        this.appId = str;
        this.apiKey = str2;
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        this.projectNumber = matcher.matches() ? matcher.group(1) : null;
        this.namespace = str3;
        this.connectTimeoutInSeconds = j;
        this.readTimeoutInSeconds = j2;
    }

    public final JSONObject createFetchRequestBody(String str, String str2, Map<String, String> map) throws FirebaseRemoteConfigClientException {
        long j;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("appInstanceId", str);
            hashMap.put("appInstanceIdToken", str2);
            hashMap.put(SMTEventParamKeys.SMT_APP_ID, this.appId);
            Locale locale = this.context.getResources().getConfiguration().locale;
            hashMap.put("countryCode", locale.getCountry());
            hashMap.put("languageCode", locale.toLanguageTag());
            hashMap.put("platformVersion", Integer.toString(VERSION.SDK_INT));
            hashMap.put(SMTEventParamKeys.SMT_TIME_ZONE, TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
                if (packageInfo != null) {
                    hashMap.put(SMTEventParamKeys.SMT_APP_VERSION, packageInfo.versionName);
                    if (VERSION.SDK_INT >= 28) {
                        j = packageInfo.getLongVersionCode();
                    } else {
                        j = (long) packageInfo.versionCode;
                    }
                    hashMap.put(SMTEventParamKeys.SMT_APP_BUILD, Long.toString(j));
                }
            } catch (NameNotFoundException unused) {
            }
            hashMap.put("packageName", this.context.getPackageName());
            hashMap.put("sdkVersion", "21.0.2");
            hashMap.put("analyticsUserProperties", new JSONObject(map));
            return new JSONObject(hashMap);
        }
        throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
    }

    public HttpURLConnection createHttpURLConnection() throws FirebaseRemoteConfigException {
        try {
            return (HttpURLConnection) new URL(String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", new Object[]{this.projectNumber, this.namespace})).openConnection();
        } catch (IOException e2) {
            throw new FirebaseRemoteConfigException(e2.getMessage());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:30|31|32|33|34|(2:38|39)|40|42|43|(2:47|48)|49|51|52|(2:55|56)|57|58|59|60) */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0155, code lost:
        throw new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException("The client had an error while calling the backend!", r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0121 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x007f A[LOOP:0: B:10:0x0079->B:12:0x007f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b1 A[Catch:{ IOException | JSONException -> 0x014b, all -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013f A[SYNTHETIC, Splitter:B:64:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014b A[ExcHandler: IOException | JSONException (r6v1 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:13:0x0095] */
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse fetch(java.net.HttpURLConnection r5, java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.Date r11) throws com.google.firebase.remoteconfig.FirebaseRemoteConfigException {
        /*
            r4 = this;
            r0 = 1
            r5.setDoOutput(r0)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            long r2 = r4.connectTimeoutInSeconds
            long r1 = r1.toMillis(r2)
            int r2 = (int) r1
            r5.setConnectTimeout(r2)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            long r2 = r4.readTimeoutInSeconds
            long r1 = r1.toMillis(r2)
            int r2 = (int) r1
            r5.setReadTimeout(r2)
            java.lang.String r1 = "If-None-Match"
            r5.setRequestProperty(r1, r9)
            java.lang.String r9 = r4.apiKey
            java.lang.String r1 = "X-Goog-Api-Key"
            r5.setRequestProperty(r1, r9)
            android.content.Context r9 = r4.context
            java.lang.String r9 = r9.getPackageName()
            java.lang.String r1 = "X-Android-Package"
            r5.setRequestProperty(r1, r9)
            r9 = 0
            r1 = 0
            android.content.Context r2 = r4.context     // Catch:{ NameNotFoundException -> 0x004e }
            android.content.Context r3 = r4.context     // Catch:{ NameNotFoundException -> 0x004e }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x004e }
            byte[] r2 = com.google.android.gms.common.util.AndroidUtilsLight.getPackageCertificateHashBytes(r2, r3)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r2 != 0) goto L_0x0049
            android.content.Context r2 = r4.context     // Catch:{ NameNotFoundException -> 0x004e }
            r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x004e }
            goto L_0x0053
        L_0x0049:
            java.lang.String r2 = com.google.android.gms.common.util.Hex.bytesToStringUppercase(r2, r9)     // Catch:{ NameNotFoundException -> 0x004e }
            goto L_0x0054
        L_0x004e:
            android.content.Context r2 = r4.context
            r2.getPackageName()
        L_0x0053:
            r2 = r1
        L_0x0054:
            java.lang.String r3 = "X-Android-Cert"
            r5.setRequestProperty(r3, r2)
            java.lang.String r2 = "X-Google-GFE-Can-Retry"
            java.lang.String r3 = "yes"
            r5.setRequestProperty(r2, r3)
            java.lang.String r2 = "X-Goog-Firebase-Installations-Auth"
            r5.setRequestProperty(r2, r7)
            java.lang.String r2 = "application/json"
            java.lang.String r3 = "Content-Type"
            r5.setRequestProperty(r3, r2)
            java.lang.String r3 = "Accept"
            r5.setRequestProperty(r3, r2)
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0079:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x0095
            java.lang.Object r2 = r10.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r5.setRequestProperty(r3, r2)
            goto L_0x0079
        L_0x0095:
            org.json.JSONObject r6 = r4.createFetchRequestBody(r6, r7, r8)     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            java.lang.String r7 = "utf-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            r4.setFetchRequestBody(r5, r6)     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            r5.connect()     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L_0x013f
            java.lang.String r6 = "ETag"
            java.lang.String r6 = r5.getHeaderField(r6)     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            org.json.JSONObject r7 = r4.getFetchResponseBody(r5)     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            r5.disconnect()
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x00c5 }
            r5.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00c5:
            java.lang.String r5 = "state"
            java.lang.Object r5 = r7.get(r5)     // Catch:{ JSONException -> 0x00d3 }
            java.lang.String r8 = "NO_CHANGE"
            boolean r5 = r5.equals(r8)     // Catch:{ JSONException -> 0x00d3 }
            r5 = r5 ^ r0
            goto L_0x00d4
        L_0x00d3:
            r5 = 1
        L_0x00d4:
            if (r5 != 0) goto L_0x00dc
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse r5 = new com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse
            r5.<init>(r11, r0, r1, r1)
            return r5
        L_0x00dc:
            com.google.firebase.remoteconfig.internal.ConfigContainer$Builder r5 = com.google.firebase.remoteconfig.internal.ConfigContainer.newBuilder()     // Catch:{ JSONException -> 0x0136 }
            r5.builderFetchTime = r11     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r8 = "entries"
            org.json.JSONObject r8 = r7.getJSONObject(r8)     // Catch:{ JSONException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
            r8 = r1
        L_0x00ea:
            if (r8 == 0) goto L_0x00f7
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f7 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00f7 }
            r10.<init>(r8)     // Catch:{ JSONException -> 0x00f7 }
            r5.builderConfigsJson = r10     // Catch:{ JSONException -> 0x00f7 }
        L_0x00f7:
            java.lang.String r8 = "experimentDescriptions"
            org.json.JSONArray r8 = r7.getJSONArray(r8)     // Catch:{ JSONException -> 0x00fe }
            goto L_0x00ff
        L_0x00fe:
            r8 = r1
        L_0x00ff:
            if (r8 == 0) goto L_0x010c
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ JSONException -> 0x010c }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x010c }
            r10.<init>(r8)     // Catch:{ JSONException -> 0x010c }
            r5.builderAbtExperiments = r10     // Catch:{ JSONException -> 0x010c }
        L_0x010c:
            java.lang.String r8 = "personalizationMetadata"
            org.json.JSONObject r1 = r7.getJSONObject(r8)     // Catch:{ JSONException -> 0x0113 }
            goto L_0x0114
        L_0x0113:
        L_0x0114:
            if (r1 == 0) goto L_0x0121
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0121 }
            java.lang.String r8 = r1.toString()     // Catch:{ JSONException -> 0x0121 }
            r7.<init>(r8)     // Catch:{ JSONException -> 0x0121 }
            r5.builderPersonalizationMetadata = r7     // Catch:{ JSONException -> 0x0121 }
        L_0x0121:
            com.google.firebase.remoteconfig.internal.ConfigContainer r7 = new com.google.firebase.remoteconfig.internal.ConfigContainer     // Catch:{ JSONException -> 0x0136 }
            org.json.JSONObject r8 = r5.builderConfigsJson     // Catch:{ JSONException -> 0x0136 }
            java.util.Date r10 = r5.builderFetchTime     // Catch:{ JSONException -> 0x0136 }
            org.json.JSONArray r11 = r5.builderAbtExperiments     // Catch:{ JSONException -> 0x0136 }
            org.json.JSONObject r5 = r5.builderPersonalizationMetadata     // Catch:{ JSONException -> 0x0136 }
            r7.<init>(r8, r10, r11, r5)     // Catch:{ JSONException -> 0x0136 }
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse r5 = new com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse
            java.util.Date r8 = r7.fetchTime
            r5.<init>(r8, r9, r7, r6)
            return r5
        L_0x0136:
            r5 = move-exception
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r6 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.String r7 = "Fetch failed: fetch response could not be parsed."
            r6.<init>(r7, r5)
            throw r6
        L_0x013f:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r7 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            java.lang.String r8 = r5.getResponseMessage()     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            r7.<init>(r6, r8)     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
            throw r7     // Catch:{ IOException -> 0x014d, JSONException -> 0x014b }
        L_0x0149:
            r6 = move-exception
            goto L_0x0156
        L_0x014b:
            r6 = move-exception
            goto L_0x014e
        L_0x014d:
            r6 = move-exception
        L_0x014e:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r7 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException     // Catch:{ all -> 0x0149 }
            java.lang.String r8 = "The client had an error while calling the backend!"
            r7.<init>(r8, r6)     // Catch:{ all -> 0x0149 }
            throw r7     // Catch:{ all -> 0x0149 }
        L_0x0156:
            r5.disconnect()
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x0160 }
            r5.close()     // Catch:{ IOException -> 0x0160 }
        L_0x0160:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient.fetch(java.net.HttpURLConnection, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.util.Date):com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse");
    }

    public final JSONObject getFetchResponseBody(URLConnection uRLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), WebViewGamesContainer.ENCODING_NAME));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read == -1) {
                return new JSONObject(sb.toString());
            }
            sb.append((char) read);
        }
    }

    public final void setFetchRequestBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}
