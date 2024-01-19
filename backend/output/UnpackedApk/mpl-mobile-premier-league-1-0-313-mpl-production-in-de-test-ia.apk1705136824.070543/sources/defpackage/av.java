package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.SDKInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import defpackage.bd;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

/* renamed from: av  reason: default package */
public abstract class av<T extends bd> {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2757b;

    /* renamed from: a  reason: collision with root package name */
    public int f2758a = -1;

    /* renamed from: a  reason: collision with other field name */
    public ag f62a;

    /* renamed from: a  reason: collision with other field name */
    public Context f63a;

    /* renamed from: a  reason: collision with other field name */
    public final List<NameValuePair> f64a;

    /* renamed from: a  reason: collision with other field name */
    public HttpClient f65a;

    /* renamed from: a  reason: collision with other field name */
    public HttpRequestBase f66a;

    /* renamed from: b  reason: collision with other field name */
    public final List<Header> f67b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public String f2759c;

    /* renamed from: d  reason: collision with root package name */
    public String f2760d;

    /* renamed from: e  reason: collision with root package name */
    public String f2761e;

    static {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LWAAndroidSDK/3.0.1/Android/");
        outline73.append(VERSION.RELEASE);
        outline73.append("/");
        outline73.append(Build.MODEL);
        f2757b = outline73.toString();
    }

    public av(Context context, ag agVar) {
        ApplicationInfo applicationInfo;
        String str;
        this.f63a = context;
        this.f62a = agVar;
        this.f64a = new ArrayList(10);
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException unused) {
            applicationInfo = null;
        }
        this.f2759c = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : context.getPackageName());
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to get verison info from app");
            outline73.append(e2.getMessage());
            cp.d("cj", outline73.toString());
            str = "N/A";
        }
        this.f2760d = str;
        this.f2761e = SDKInfo.VERSION;
    }

    public final T a() throws AuthError {
        if (this.f65a == null) {
            this.f65a = new DefaultHttpClient();
            String a2 = a();
            try {
                s sVar = new s(this.f63a, this.f62a);
                sVar.f144a = y.PANDA;
                sVar.f146a = a();
                String a3 = sVar.a();
                this.f66a = a(new URL(a3 + a2).toString());
            } catch (MalformedURLException e2) {
                throw new AuthError("MalformedURLException", e2, ERROR_TYPE.ERROR_BAD_PARAM);
            }
        }
        this.f65a.getParams().setParameter("http.useragent", f2757b);
        List<BasicNameValuePair> c2 = c();
        if (c2 != null) {
            this.f64a.addAll(c2);
        }
        this.f64a.add(new BasicNameValuePair("app_name", this.f2759c));
        if (this.f2760d != null) {
            this.f64a.add(new BasicNameValuePair("app_version", this.f2760d));
        }
        if (!TextUtils.isEmpty(Build.MANUFACTURER) && !Build.MANUFACTURER.equals("unknown")) {
            this.f64a.add(new BasicNameValuePair("di.hw.name", Build.MANUFACTURER));
        }
        if (!TextUtils.isEmpty(Build.MODEL) && !Build.MODEL.equals("unknown")) {
            this.f64a.add(new BasicNameValuePair("di.hw.version", Build.MODEL));
        }
        this.f64a.add(new BasicNameValuePair("di.os.name", "Android"));
        if (!TextUtils.isEmpty(VERSION.RELEASE) && !VERSION.RELEASE.equals("unknown")) {
            this.f64a.add(new BasicNameValuePair("di.os.version", VERSION.RELEASE));
        }
        this.f64a.add(new BasicNameValuePair("di.sdk.version", this.f2761e));
        this.f67b.add(new BasicHeader("Accept-Encoding", "gzip, deflate"));
        this.f67b.add(new BasicHeader("Accept-Language", "en-us,en;q=0.5"));
        this.f67b.add(new BasicHeader("Accept", "application/xml,application/xhtml+xml,text/html,application/json;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5"));
        this.f67b.add(new BasicHeader(Names.ACCEPT_CHARSET, "utf-8, iso-8859-1, utf-16, *;q=0.7"));
        List a4 = a();
        if (a4 != null) {
            this.f67b.addAll(a4);
        }
        try {
            a();
            for (Header addHeader : this.f67b) {
                this.f66a.addHeader(addHeader);
            }
            HttpResponse httpResponse = null;
            try {
                cp.c("av", "Request url: " + this.f66a.getURI());
                for (int i = 0; i <= 2; i++) {
                    httpResponse = a();
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (!(statusCode >= 500 && statusCode < 600)) {
                        break;
                    }
                    if (i != 2) {
                        httpResponse.getEntity().consumeContent();
                    }
                    httpResponse.getStatusLine().getStatusCode();
                }
                HttpClient httpClient = this.f65a;
                if (httpClient != null) {
                    httpClient.getConnectionManager().closeIdleConnections(5, TimeUnit.SECONDS);
                }
                if (this.f66a != null) {
                    try {
                        b();
                    } catch (IOException e3) {
                        e3.toString();
                    }
                }
                return a(httpResponse);
            } catch (ClientProtocolException e4) {
                cp.b("av", "Received communication error when executing token request:" + e4.toString());
                throw new AuthError("Received communication error when executing token request", e4, ERROR_TYPE.ERROR_COM);
            } catch (IOException e5) {
                cp.b("av", "Received IO error when executing token request:" + e5.toString());
                throw new AuthError("Received communication error when executing token request", e5, ERROR_TYPE.ERROR_IO);
            } catch (IllegalStateException e6) {
                cp.b("av", "Received IllegalStateException error when executing token request:" + e6.toString());
                throw new AuthError("Received communication error when executing token request", e6, ERROR_TYPE.ERROR_COM);
            } catch (Throwable th) {
                HttpClient httpClient2 = this.f65a;
                if (httpClient2 != null) {
                    httpClient2.getConnectionManager().closeIdleConnections(5, TimeUnit.SECONDS);
                }
                if (this.f66a != null) {
                    try {
                        b();
                    } catch (IOException e7) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("IOException consuming httppost entity content ");
                        outline73.append(e7.toString());
                        cp.b("av", outline73.toString());
                    }
                }
                throw th;
            }
        } catch (UnsupportedEncodingException e8) {
            throw new AuthError(e8.getMessage(), e8, ERROR_TYPE.ERROR_BAD_PARAM);
        }
    }

    public abstract T a(HttpResponse httpResponse);

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m247a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract List<Header> m248a();

    public HttpRequestBase a(String str) {
        return new HttpPost(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m251a() {
        return false;
    }

    public void b() throws IOException {
        this.f66a.getEntity().consumeContent();
    }

    public abstract List<BasicNameValuePair> c();

    /* renamed from: c  reason: collision with other method in class */
    public abstract void m252c();

    /* renamed from: a  reason: collision with other method in class */
    public HttpResponse m249a() throws ClientProtocolException, IOException {
        if (this.f2758a != -1) {
            HttpParams params = this.f66a.getParams();
            HttpConnectionParams.setSoTimeout(params, this.f2758a);
            this.f66a.setParams(params);
        }
        cp.a((String) "av", (String) "Logging Request info.", "UserAgent = " + ((String) this.f65a.getParams().getParameter("http.useragent")));
        Header[] allHeaders = this.f66a.getAllHeaders();
        if (allHeaders != null) {
            for (Header header : allHeaders) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Header used for request: name=");
                outline73.append(header.getName());
                String sb = outline73.toString();
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("val=");
                outline732.append(header.getValue());
                cp.a((String) "av", sb, outline732.toString());
            }
        }
        c();
        return this.f65a.execute(this.f66a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m250a() throws UnsupportedEncodingException, AuthError {
        for (NameValuePair next : this.f64a) {
            if (next != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("name=");
                outline73.append(next.getName());
                outline73.append(" val=");
                outline73.append(next.getValue());
                cp.a((String) "av", (String) "Parameter Added to request", outline73.toString());
            } else {
                cp.b("av", "Parameter Added to request was NULL");
            }
        }
        this.f66a.setEntity(new UrlEncodedFormEntity(this.f64a));
    }
}
