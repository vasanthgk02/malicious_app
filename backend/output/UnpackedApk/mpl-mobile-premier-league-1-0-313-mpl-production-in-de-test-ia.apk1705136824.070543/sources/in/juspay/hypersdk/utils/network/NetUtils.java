package in.juspay.hypersdk.utils.network;

import android.content.Context;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import in.juspay.hypersdk.R;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class NetUtils {
    public static String USER_AGENT;
    public int connectionTimeout;
    public int readTimeout;
    public final boolean sslPinningRequired;
    public SSLSocketFactory sslSocketFactory;

    static {
        String property = System.getProperty("http.agent");
        USER_AGENT = property;
        if (property == null || property.length() == 0) {
            USER_AGENT = "Juspay Express Checkout Android SDK";
        }
    }

    public NetUtils(int i, int i2) {
        this.connectionTimeout = i;
        this.readTimeout = i2;
        this.sslPinningRequired = false;
        this.sslSocketFactory = new JuspaySSLSocketFactory();
    }

    public NetUtils(int i, int i2, boolean z) {
        this.connectionTimeout = i;
        this.readTimeout = i2;
        this.sslPinningRequired = z;
        this.sslSocketFactory = new JuspaySSLSocketFactory();
    }

    public static HttpURLConnection doPut(Context context, URL url, byte[] bArr, Map<String, String> map, NetUtils netUtils) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setRequestProperty("X-App-Name", context.getString(R.string.godel_app_name));
        if ((httpURLConnection instanceof HttpsURLConnection) && netUtils.getSslSocketFactory() != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(netUtils.getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.setRequestProperty(next, map.get(next));
            }
        }
        if (bArr != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
        throw th;
    }

    @Keep
    public static String generateQueryString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Entry next : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    private HttpURLConnection initAndGetConnection(URL url) {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
        uRLConnection.setDoInput(true);
        uRLConnection.setDoOutput(true);
        uRLConnection.setReadTimeout(this.readTimeout);
        uRLConnection.setConnectTimeout(this.connectionTimeout);
        if ((uRLConnection instanceof HttpsURLConnection) && getSslSocketFactory() != null) {
            ((HttpsURLConnection) uRLConnection).setSSLSocketFactory(getSslSocketFactory());
        }
        uRLConnection.setRequestProperty("User-Agent", USER_AGENT);
        uRLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        uRLConnection.setRequestProperty("X-Powered-By", "Juspay EC SDK for Android");
        return (HttpURLConnection) uRLConnection;
    }

    public HttpURLConnection deleteUrl(URL url) {
        return doDelete(url, null, "application/x-www-form-urlencoded", null);
    }

    public HttpURLConnection deleteUrl(URL url, Map<String, String> map) {
        return doDelete(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", null);
    }

    public HttpURLConnection deleteUrl(URL url, Map<String, String> map, String str) {
        return doDelete(url, str.getBytes(), "application/x-www-form-urlencoded", map);
    }

    public HttpURLConnection deleteUrl(URL url, Map<String, String> map, Map<String, String> map2) {
        return doDelete(url, generateQueryString(map2).getBytes(), DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, map);
    }

    public HttpURLConnection doDelete(URL url, byte[] bArr, String str, Map<String, String> map) {
        HttpURLConnection initAndGetConnection = initAndGetConnection(url);
        initAndGetConnection.setRequestMethod("DELETE");
        initAndGetConnection.setRequestProperty("Content-Type", str);
        if ((initAndGetConnection instanceof HttpsURLConnection) && getSslSocketFactory() != null) {
            ((HttpsURLConnection) initAndGetConnection).setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                initAndGetConnection.setRequestProperty(next, map.get(next));
            }
        }
        if (bArr != null) {
            OutputStream outputStream = initAndGetConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        initAndGetConnection.connect();
        return initAndGetConnection;
        throw th;
    }

    public HttpURLConnection doGet(String str, Map<String, String> map, Map<String, String> map2) {
        String generateQueryString = generateQueryString(map2);
        StringBuilder sb = new StringBuilder(str);
        if (generateQueryString.length() > 0) {
            str = GeneratedOutlineSupport.outline62(sb, ColorPropConverter.PREFIX_ATTR, generateQueryString);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(HttpGetRequest.METHOD_GET);
        if ((httpURLConnection instanceof HttpsURLConnection) && getSslSocketFactory() != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.setRequestProperty(next, map.get(next));
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public HttpURLConnection doHead(String str, Map<String, String> map, Map<String, String> map2) {
        String generateQueryString = generateQueryString(map2);
        StringBuilder sb = new StringBuilder(str);
        if (generateQueryString.length() > 0) {
            str = GeneratedOutlineSupport.outline62(sb, ColorPropConverter.PREFIX_ATTR, generateQueryString);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(BuildConfig.SCM_BRANCH);
        if ((httpURLConnection instanceof HttpsURLConnection) && getSslSocketFactory() != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.setRequestProperty(next, map.get(next));
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public HttpURLConnection doPost(URL url, byte[] bArr, String str, Map<String, String> map) {
        HttpURLConnection initAndGetConnection = initAndGetConnection(url);
        initAndGetConnection.setRequestMethod(RNCWebViewManager.HTTP_METHOD_POST);
        initAndGetConnection.setRequestProperty("Content-Type", str);
        if ((initAndGetConnection instanceof HttpsURLConnection) && getSslSocketFactory() != null) {
            ((HttpsURLConnection) initAndGetConnection).setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                initAndGetConnection.setRequestProperty(next, map.get(next));
            }
        }
        if (bArr != null) {
            OutputStream outputStream = initAndGetConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        initAndGetConnection.connect();
        return initAndGetConnection;
        throw th;
    }

    public byte[] fetchIfModified(String str, Map<String, String> map) {
        HttpURLConnection doGet = doGet(str, map, null);
        if (doGet.getResponseCode() == 200) {
            return new JuspayHttpResponse(doGet).responsePayload;
        }
        return null;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public HttpURLConnection postForm(URL url, Map<String, String> map) {
        return doPost(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", null);
    }

    public <T> HttpURLConnection postJson(URL url, T t) {
        return doPost(url, t.toString().getBytes(), DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, null);
    }

    public HttpURLConnection postUrl(URL url) {
        return doPost(url, null, "application/x-www-form-urlencoded", null);
    }

    public HttpURLConnection postUrl(URL url, Map<String, String> map) {
        return doPost(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", null);
    }

    public HttpURLConnection postUrl(URL url, Map<String, String> map, String str) {
        return doPost(url, str.getBytes(), "application/x-www-form-urlencoded", map);
    }

    public HttpURLConnection postUrl(URL url, Map<String, String> map, Map<String, String> map2) {
        return doPost(url, generateQueryString(map2).getBytes(), DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, map);
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }
}
