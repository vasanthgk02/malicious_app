package com.braintreepayments.api.internal;

import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.AuthenticationException;
import com.braintreepayments.api.exceptions.AuthorizationException;
import com.braintreepayments.api.exceptions.DownForMaintenanceException;
import com.braintreepayments.api.exceptions.RateLimitException;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.exceptions.UnprocessableEntityException;
import com.braintreepayments.api.exceptions.UpgradeRequiredException;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.internal.HttpClient;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.squareup.picasso.NetworkRequestHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import sfs2x.client.requests.BaseRequest;

public class HttpClient<T extends HttpClient> {
    public String mBaseUrl;
    public int mConnectTimeout = ((int) TimeUnit.SECONDS.toMillis(30));
    public final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    public int mReadTimeout = ((int) TimeUnit.SECONDS.toMillis(30));
    public SSLSocketFactory mSSLSocketFactory;
    public final ExecutorService mThreadPool = Executors.newCachedThreadPool();
    public String mUserAgent = "braintree/core/3.17.4";

    public HttpClient() {
        try {
            this.mSSLSocketFactory = new TLSSocketFactory();
        } catch (SSLException unused) {
            this.mSSLSocketFactory = null;
        }
    }

    public void get(final String str, final HttpResponseCallback httpResponseCallback) {
        if (str == null) {
            postCallbackOnMainThread(httpResponseCallback, new IllegalArgumentException("Path cannot be null"));
            return;
        }
        if (!str.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
            str = GeneratedOutlineSupport.outline62(new StringBuilder(), this.mBaseUrl, str);
        }
        this.mThreadPool.submit(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
            /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    r0 = 0
                    com.braintreepayments.api.internal.HttpClient r1 = com.braintreepayments.api.internal.HttpClient.this     // Catch:{ Exception -> 0x002d, all -> 0x002b }
                    java.lang.String r2 = r3     // Catch:{ Exception -> 0x002d, all -> 0x002b }
                    java.net.HttpURLConnection r1 = r1.init(r2)     // Catch:{ Exception -> 0x002d, all -> 0x002b }
                    java.lang.String r2 = "GET"
                    r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x0029 }
                    com.braintreepayments.api.internal.HttpClient r2 = com.braintreepayments.api.internal.HttpClient.this     // Catch:{ Exception -> 0x0029 }
                    com.braintreepayments.api.interfaces.HttpResponseCallback r3 = r4     // Catch:{ Exception -> 0x0029 }
                    com.braintreepayments.api.internal.HttpClient r4 = com.braintreepayments.api.internal.HttpClient.this     // Catch:{ Exception -> 0x0029 }
                    java.lang.String r4 = r4.parseResponse(r1)     // Catch:{ Exception -> 0x0029 }
                    if (r2 == 0) goto L_0x0028
                    if (r3 != 0) goto L_0x001d
                    goto L_0x003a
                L_0x001d:
                    android.os.Handler r0 = r2.mMainThreadHandler     // Catch:{ Exception -> 0x0029 }
                    com.braintreepayments.api.internal.HttpClient$3 r5 = new com.braintreepayments.api.internal.HttpClient$3     // Catch:{ Exception -> 0x0029 }
                    r5.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x0029 }
                    r0.post(r5)     // Catch:{ Exception -> 0x0029 }
                    goto L_0x003a
                L_0x0028:
                    throw r0     // Catch:{ Exception -> 0x0029 }
                L_0x0029:
                    r0 = move-exception
                    goto L_0x0031
                L_0x002b:
                    r1 = move-exception
                    goto L_0x0042
                L_0x002d:
                    r1 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                L_0x0031:
                    com.braintreepayments.api.internal.HttpClient r2 = com.braintreepayments.api.internal.HttpClient.this     // Catch:{ all -> 0x003e }
                    com.braintreepayments.api.interfaces.HttpResponseCallback r3 = r4     // Catch:{ all -> 0x003e }
                    r2.postCallbackOnMainThread(r3, r0)     // Catch:{ all -> 0x003e }
                    if (r1 == 0) goto L_0x003d
                L_0x003a:
                    r1.disconnect()
                L_0x003d:
                    return
                L_0x003e:
                    r0 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                L_0x0042:
                    if (r0 == 0) goto L_0x0047
                    r0.disconnect()
                L_0x0047:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.internal.HttpClient.AnonymousClass1.run():void");
            }
        });
    }

    public HttpURLConnection init(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        if (httpURLConnection instanceof HttpsURLConnection) {
            SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
            if (sSLSocketFactory != null) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
            } else {
                throw new SSLException("SSLSocketFactory was not set or failed to initialize");
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", this.mUserAgent);
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection.setConnectTimeout(this.mConnectTimeout);
        httpURLConnection.setReadTimeout(this.mReadTimeout);
        return httpURLConnection;
    }

    public String parseResponse(HttpURLConnection httpURLConnection) throws Exception {
        int responseCode = httpURLConnection.getResponseCode();
        boolean equals = "gzip".equals(httpURLConnection.getContentEncoding());
        if (responseCode != 400) {
            if (responseCode == 401) {
                throw new AuthenticationException(readStream(httpURLConnection.getErrorStream(), equals));
            } else if (responseCode == 403) {
                throw new AuthorizationException(readStream(httpURLConnection.getErrorStream(), equals));
            } else if (responseCode != 422) {
                if (responseCode == 426) {
                    throw new UpgradeRequiredException(readStream(httpURLConnection.getErrorStream(), equals));
                } else if (responseCode == 429) {
                    throw new RateLimitException("You are being rate-limited. Please try again in a few minutes.");
                } else if (responseCode == 500) {
                    throw new ServerException(readStream(httpURLConnection.getErrorStream(), equals));
                } else if (responseCode != 503) {
                    switch (responseCode) {
                        case 200:
                        case BaseRequest.AddBuddy /*201*/:
                        case 202:
                            return readStream(httpURLConnection.getInputStream(), equals);
                        default:
                            throw new UnexpectedException(readStream(httpURLConnection.getErrorStream(), equals));
                    }
                } else {
                    throw new DownForMaintenanceException(readStream(httpURLConnection.getErrorStream(), equals));
                }
            }
        }
        throw new UnprocessableEntityException(readStream(httpURLConnection.getErrorStream(), equals));
    }

    public void post(final String str, final String str2, final HttpResponseCallback httpResponseCallback) {
        if (str == null) {
            postCallbackOnMainThread(httpResponseCallback, new IllegalArgumentException("Path cannot be null"));
        } else {
            this.mThreadPool.submit(new Runnable() {
                public void run() {
                    try {
                        HttpClient httpClient = HttpClient.this;
                        HttpResponseCallback httpResponseCallback = httpResponseCallback;
                        String post = HttpClient.this.post(str, str2);
                        if (httpClient == null) {
                            throw null;
                        } else if (httpResponseCallback != null) {
                            httpClient.mMainThreadHandler.post(new Runnable(httpClient, httpResponseCallback, post) {
                                public final /* synthetic */ HttpResponseCallback val$callback;
                                public final /* synthetic */ String val$response;

                                {
                                    this.val$callback = r2;
                                    this.val$response = r3;
                                }

                                public void run() {
                                    this.val$callback.success(this.val$response);
                                }
                            });
                        }
                    } catch (Exception e2) {
                        HttpClient.this.postCallbackOnMainThread(httpResponseCallback, e2);
                    }
                }
            });
        }
    }

    public void postCallbackOnMainThread(final HttpResponseCallback httpResponseCallback, final Exception exc) {
        if (httpResponseCallback != null) {
            this.mMainThreadHandler.post(new Runnable(this) {
                public void run() {
                    httpResponseCallback.failure(exc);
                }
            });
        }
    }

    public final String readStream(InputStream inputStream, boolean z) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (z) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                throw th;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        try {
            inputStream.close();
        } catch (IOException unused2) {
        }
        return str;
    }

    public String post(String str, String str2) throws Exception {
        HttpURLConnection init;
        HttpURLConnection httpURLConnection = null;
        try {
            if (str.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
                init = init(str);
            } else {
                init = init(this.mBaseUrl + str);
            }
            HttpURLConnection httpURLConnection2 = init;
            httpURLConnection2.setRequestProperty("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            httpURLConnection2.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
            httpURLConnection2.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection2.getOutputStream(), "UTF-8");
            outputStreamWriter.write(str2, 0, str2.length());
            outputStreamWriter.flush();
            outputStreamWriter.close();
            String parseResponse = parseResponse(httpURLConnection2);
            httpURLConnection2.disconnect();
            return parseResponse;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
