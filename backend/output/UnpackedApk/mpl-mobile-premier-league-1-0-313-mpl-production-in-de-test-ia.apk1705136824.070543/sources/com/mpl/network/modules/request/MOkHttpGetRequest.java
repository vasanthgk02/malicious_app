package com.mpl.network.modules.request;

import a.a.a.a.a.e;
import a.a.a.a.d.b;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.fontbox.cmap.CMapParser;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Keep
public class MOkHttpGetRequest extends MRequest {
    public static final String TAG = "NetworkLib: MOkHttpGetRequest";

    public static final class Builder {
        public int connectTimeout;
        public File destFile;
        public String destFileName;
        public String host;
        public boolean isCachingRequired;
        public String mAndroidAppVersion;
        public List<MHeader> mHeaders;
        public String mMainUrl;
        public OkHttpClient mOkHttpClient;
        public Map<String, String> mQueryParams;
        public String mReactVersion;
        public RequestPriority mRequestPriority = RequestPriority.HIGH;
        public RequestType mRequestType = RequestType.GET;
        public IResponseListener mResponseListener;
        public int pingInterval;
        public int port;
        public int readTimeout;
        public Request request;
        public RequestBody requestBody;
        public boolean retryOnConnectionFailure;
        public String scheme;
        public Object tag;
        public int type;
        public List<String> urlPathSegments;
        public int writeTimeout;

        private Builder setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
        }

        private Builder setRequest(Request request2) {
            this.request = request2;
            return this;
        }

        private Builder setRequestBody(RequestBody requestBody2) {
            this.requestBody = requestBody2;
            return this;
        }

        private Builder setRequestType(RequestType requestType) {
            this.mRequestType = requestType;
            return this;
        }

        public Builder addHeader(MHeader mHeader) {
            if (mHeader != null) {
                if (this.mHeaders == null) {
                    this.mHeaders = new ArrayList();
                }
                this.mHeaders.add(mHeader);
                return this;
            }
            throw new NullPointerException("header == null");
        }

        public Builder addQueryParam(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new NullPointerException("key == null or value == null");
            }
            if (this.mQueryParams == null) {
                this.mQueryParams = new IdentityHashMap();
            }
            this.mQueryParams.put(str, str2);
            return this;
        }

        public MOkHttpGetRequest build() {
            if (this.mResponseListener != null) {
                return new MOkHttpGetRequest(this);
            }
            throw new NullPointerException("mResponseListener == null");
        }

        public Builder isCacheRequired(boolean z) {
            this.isCachingRequired = z;
            return this;
        }

        public Builder setAndroidAppVersion(String str) {
            this.mAndroidAppVersion = str;
            return this;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setConnectTimeout(int i, TimeUnit timeUnit) {
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setDestFile(File file) {
            this.destFile = file;
            return this;
        }

        public Builder setDestFileName(String str) {
            this.destFileName = str;
            return this;
        }

        public Builder setHeaders(List<MHeader> list) {
            List<MHeader> list2 = this.mHeaders;
            if (list2 != null) {
                list2.addAll(list);
            } else {
                this.mHeaders = list;
            }
            return this;
        }

        public Builder setHost(String str) {
            if (this.mMainUrl == null) {
                this.host = str;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setPathSegments(List<String> list) {
            this.urlPathSegments = list;
            return this;
        }

        public Builder setPingInterval(int i) {
            this.pingInterval = b.a("interval", (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setPingInterval(int i, TimeUnit timeUnit) {
            this.pingInterval = b.a("interval", (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setPort(int i) {
            if (this.mMainUrl == null) {
                this.port = i;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setQueryParams(Map<String, String> map) {
            Map<String, String> map2 = this.mQueryParams;
            if (map2 != null) {
                map2.putAll(map);
            } else {
                this.mQueryParams = map;
            }
            return this;
        }

        public Builder setReactVersion(String str) {
            this.mReactVersion = str;
            return this;
        }

        public Builder setReadTimeout(int i) {
            this.readTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setReadTimeout(int i, TimeUnit timeUnit) {
            this.readTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setRequestPriority(RequestPriority requestPriority) {
            this.mRequestPriority = requestPriority;
            return this;
        }

        public Builder setResponseListener(IResponseListener iResponseListener) {
            this.mResponseListener = iResponseListener;
            return this;
        }

        public Builder setRetryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder setScheme(String str) {
            if (this.mMainUrl == null) {
                this.scheme = str;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setType(int i) {
            this.type = i;
            return this;
        }

        public Builder setUrl(String str) {
            if (!TextUtils.isEmpty(this.scheme) || !TextUtils.isEmpty(this.host) || this.port != 0) {
                throw new RuntimeException("scheme or host is already set. ");
            }
            this.mMainUrl = str;
            return this;
        }

        public Builder setWriteTimeout(int i) {
            this.writeTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setWriteTimeout(int i, TimeUnit timeUnit) {
            this.writeTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }
    }

    public MOkHttpGetRequest() {
        MLog.d(TAG, "MOkHttpGetRequest() called");
    }

    public MOkHttpGetRequest(Builder builder) {
        MLog.d(TAG, "MOkHttpGetRequest() called with: builder = [" + builder + CMapParser.MARK_END_OF_ARRAY);
        this.type = builder.type;
        this.destFile = builder.destFile;
        this.destFileName = builder.destFileName;
        this.mHeaders = builder.mHeaders;
        this.mRequestType = builder.mRequestType;
        this.mQueryParams = builder.mQueryParams;
        this.mMainUrl = builder.mMainUrl;
        this.tag = builder.tag;
        this.mRequestPriority = builder.mRequestPriority;
        this.urlPathSegments = builder.urlPathSegments;
        this.mResponseListener = builder.mResponseListener;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        this.requestBody = builder.requestBody;
        this.scheme = builder.scheme;
        this.port = builder.port;
        this.host = builder.host;
        this.request = builder.request;
        this.isCachingRequired = builder.isCachingRequired;
        this.mAndroidAppVersion = builder.mAndroidAppVersion;
        this.mReactVersion = builder.mReactVersion;
        this.mOkHttpClient = e.c().a((MRequest) this);
    }

    public Object clone() {
        throw new CloneNotSupportedException();
    }

    public OkHttpClient prepareClient() {
        return getOkHttpClient();
    }

    public Request prepareRequest() {
        HttpUrl httpUrl;
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        builder.get();
        if (TextUtils.isEmpty(getUrl())) {
            okhttp3.HttpUrl.Builder builder2 = new okhttp3.HttpUrl.Builder();
            if (!TextUtils.isEmpty(getHost())) {
                builder2.host(getHost());
            }
            if (!TextUtils.isEmpty(getScheme())) {
                builder2.scheme(getScheme());
            }
            if (getPort() != 0) {
                builder2.port(getPort());
            }
            httpUrl = builder2.build();
        } else {
            httpUrl = HttpUrl.parse(getUrl());
        }
        if (httpUrl != null) {
            if (getQueryParams() != null && getQueryParams().size() > 0) {
                okhttp3.HttpUrl.Builder newBuilder = httpUrl.newBuilder();
                for (Entry next : getQueryParams().entrySet()) {
                    newBuilder.addQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                httpUrl = newBuilder.build();
            }
            if (getUrlPathSegments() != null && getUrlPathSegments().size() > 0) {
                okhttp3.HttpUrl.Builder newBuilder2 = httpUrl.newBuilder();
                for (String addPathSegment : getUrlPathSegments()) {
                    newBuilder2.addPathSegment(addPathSegment);
                }
                httpUrl = newBuilder2.build();
            }
            MLog.e(TAG, "Url is: ", httpUrl);
            builder.url(httpUrl);
        } else {
            MLog.e(TAG, "Url is null");
        }
        if (getTag() != null) {
            builder.tag(getTag());
        }
        if (getHeaders() != null && getHeaders().size() > 0) {
            for (MHeader next2 : getHeaders()) {
                MLog.d(TAG, "Adding Header: ", next2.toString());
                builder.addHeader(next2.getKey(), next2.getValue());
            }
        }
        if (getDownloadedSize() > 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("bytes=");
            outline73.append(String.valueOf(getDownloadedSize()));
            outline73.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            builder.addHeader("Range", outline73.toString());
        }
        if (getTag() != null) {
            builder.tag(getTag());
        }
        builder.cacheControl(isCachingRequired() ? CacheControl.FORCE_CACHE : CacheControl.FORCE_NETWORK);
        return builder.build();
    }

    public RequestBody prepareRequestBody() {
        return null;
    }

    public String printRequest() {
        return toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010b, code lost:
        if (r2 == null) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015c, code lost:
        if (r2 == null) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a9, code lost:
        if (r2 == null) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ab, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ae, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E> void processResponse(okhttp3.Call r9, okhttp3.Response r10, com.mpl.network.modules.listeners.IResponseListener<E> r11) {
        /*
            r8 = this;
            java.lang.String r9 = "Response is null from server"
            r0 = 1000(0x3e8, float:1.401E-42)
            r1 = 1001(0x3e9, float:1.403E-42)
            r2 = 0
            if (r10 == 0) goto L_0x00eb
            okhttp3.ResponseBody r2 = r10.body()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r9 = r2.string()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r1 = "NetworkLib: MOkHttpGetRequest"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r4 = 0
            java.lang.String r5 = "responseBody: "
            r3[r4] = r5     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r4 = 1
            r3[r4] = r9     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            com.mpl.MLog.i(r1, r3)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            long r3 = r10.receivedResponseAtMillis()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            long r5 = r10.sentRequestAtMillis()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            long r3 = r3 - r5
            r11.calculateResponse(r3)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            okhttp3.Headers r1 = r10.headers()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r3.<init>()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r1 == 0) goto L_0x0061
            int r4 = r1.size()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r4 <= 0) goto L_0x0061
            java.util.Set r4 = r1.names()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x0048:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r5 == 0) goto L_0x0061
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r6 = r1.get(r5)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            com.mpl.network.modules.engine.MHeader r7 = new com.mpl.network.modules.engine.MHeader     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r7.<init>(r5, r6)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r3.add(r7)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            goto L_0x0048
        L_0x0061:
            int r1 = r3.size()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r1 <= 0) goto L_0x006a
            r11.onProcessHeader(r3)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x006a:
            java.lang.reflect.Type r1 = r11.mType     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != r3) goto L_0x0080
            r11.onResponseSuccess(r9)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x0073:
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            okhttp3.internal.Util.closeQuietly(r2)
            return
        L_0x0080:
            java.lang.reflect.Type r1 = r11.mType     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.Class<org.json.JSONObject> r3 = org.json.JSONObject.class
            if (r1 != r3) goto L_0x008f
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x008b:
            r11.onResponseSuccess(r1)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            goto L_0x0073
        L_0x008f:
            java.lang.reflect.Type r1 = r11.mType     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.Class<org.json.JSONArray> r3 = org.json.JSONArray.class
            if (r1 != r3) goto L_0x009b
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            goto L_0x008b
        L_0x009b:
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r1.<init>()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.reflect.Type r3 = r11.mType     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.Object r9 = r1.fromJson(r9, r3)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r11.onResponseSuccess(r9)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            goto L_0x0102
        L_0x00aa:
            com.mpl.network.modules.utils.MException$b r9 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r9.<init>()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            okhttp3.Headers r3 = r10.headers()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r3 == 0) goto L_0x00d7
            int r4 = r3.size()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r4 <= 0) goto L_0x00d7
            java.util.Set r4 = r3.names()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x00c3:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            if (r5 == 0) goto L_0x00d7
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r6 = r3.get(r5)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r9.a(r5, r6)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            goto L_0x00c3
        L_0x00d7:
            r9.f966c = r1     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r3 = "Response body is null"
            r1.<init>(r3)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r9.f965b = r1     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.String r1 = "Response body is null from server"
            r9.f964a = r1     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            com.mpl.network.modules.utils.MException r9 = r9.a()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            goto L_0x00ff
        L_0x00eb:
            com.mpl.network.modules.utils.MException$b r3 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r3.<init>()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r3.f966c = r1     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r3.f965b = r1     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            r3.f964a = r9     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
            com.mpl.network.modules.utils.MException r9 = r3.a()     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x00ff:
            r11.onResponseFail(r9)     // Catch:{ IOException -> 0x015f, JSONException -> 0x0112 }
        L_0x0102:
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r2 == 0) goto L_0x01ae
            goto L_0x01ab
        L_0x010f:
            r9 = move-exception
            goto L_0x01af
        L_0x0112:
            r9 = move-exception
            com.mpl.network.modules.utils.MException$b r1 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x010f }
            r1.<init>()     // Catch:{ all -> 0x010f }
            if (r10 == 0) goto L_0x0142
            okhttp3.Headers r3 = r10.headers()     // Catch:{ all -> 0x010f }
            if (r3 == 0) goto L_0x0142
            int r4 = r3.size()     // Catch:{ all -> 0x010f }
            if (r4 <= 0) goto L_0x0142
            java.util.Set r4 = r3.names()     // Catch:{ all -> 0x010f }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x010f }
        L_0x012e:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x010f }
            if (r5 == 0) goto L_0x0142
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x010f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x010f }
            java.lang.String r6 = r3.get(r5)     // Catch:{ all -> 0x010f }
            r1.a(r5, r6)     // Catch:{ all -> 0x010f }
            goto L_0x012e
        L_0x0142:
            r1.f966c = r0     // Catch:{ all -> 0x010f }
            r1.f965b = r9     // Catch:{ all -> 0x010f }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x010f }
            r1.f964a = r9     // Catch:{ all -> 0x010f }
            com.mpl.network.modules.utils.MException r9 = r1.a()     // Catch:{ all -> 0x010f }
            r11.onResponseFail(r9)     // Catch:{ all -> 0x010f }
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r2 == 0) goto L_0x01ae
            goto L_0x01ab
        L_0x015f:
            r9 = move-exception
            com.mpl.network.modules.utils.MException$b r1 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x010f }
            r1.<init>()     // Catch:{ all -> 0x010f }
            if (r10 == 0) goto L_0x018f
            okhttp3.Headers r3 = r10.headers()     // Catch:{ all -> 0x010f }
            if (r3 == 0) goto L_0x018f
            int r4 = r3.size()     // Catch:{ all -> 0x010f }
            if (r4 <= 0) goto L_0x018f
            java.util.Set r4 = r3.names()     // Catch:{ all -> 0x010f }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x010f }
        L_0x017b:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x010f }
            if (r5 == 0) goto L_0x018f
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x010f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x010f }
            java.lang.String r6 = r3.get(r5)     // Catch:{ all -> 0x010f }
            r1.a(r5, r6)     // Catch:{ all -> 0x010f }
            goto L_0x017b
        L_0x018f:
            r1.f966c = r0     // Catch:{ all -> 0x010f }
            r1.f965b = r9     // Catch:{ all -> 0x010f }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x010f }
            r1.f964a = r9     // Catch:{ all -> 0x010f }
            com.mpl.network.modules.utils.MException r9 = r1.a()     // Catch:{ all -> 0x010f }
            r11.onResponseFail(r9)     // Catch:{ all -> 0x010f }
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r2 == 0) goto L_0x01ae
        L_0x01ab:
            okhttp3.internal.Util.closeQuietly(r2)
        L_0x01ae:
            return
        L_0x01af:
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r2 == 0) goto L_0x01bd
            okhttp3.internal.Util.closeQuietly(r2)
        L_0x01bd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.request.MOkHttpGetRequest.processResponse(okhttp3.Call, okhttp3.Response, com.mpl.network.modules.listeners.IResponseListener):void");
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MOkHttpGetRequest{mPostFormParams=");
        outline73.append(this.mPostFormParams);
        outline73.append(", content='");
        GeneratedOutlineSupport.outline99(outline73, this.content, ExtendedMessageFormat.QUOTE, ", bytes=");
        outline73.append(Arrays.toString(this.bytes));
        outline73.append(", file=");
        outline73.append(this.file);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", uploadingFiles=");
        outline73.append(Arrays.toString(this.uploadingFiles));
        outline73.append(", destFile=");
        outline73.append(this.destFile);
        outline73.append(", destFileName='");
        GeneratedOutlineSupport.outline99(outline73, this.destFileName, ExtendedMessageFormat.QUOTE, ", mHeaders=");
        outline73.append(this.mHeaders);
        outline73.append(", mRequestType=");
        outline73.append(this.mRequestType);
        outline73.append(", mQueryParams=");
        outline73.append(this.mQueryParams);
        outline73.append(", tag=");
        outline73.append(this.tag);
        outline73.append(", mRequestPriority=");
        outline73.append(this.mRequestPriority);
        outline73.append(", urlPathSegments=");
        outline73.append(this.urlPathSegments);
        outline73.append(", mResponseListener=");
        outline73.append(this.mResponseListener);
        outline73.append(", retryOnConnectionFailure=");
        outline73.append(this.retryOnConnectionFailure);
        outline73.append(", connectTimeout=");
        outline73.append(this.connectTimeout);
        outline73.append(", readTimeout=");
        outline73.append(this.readTimeout);
        outline73.append(", writeTimeout=");
        outline73.append(this.writeTimeout);
        outline73.append(", pingInterval=");
        outline73.append(this.pingInterval);
        outline73.append(", requestBody=");
        outline73.append(this.requestBody);
        outline73.append(", mOkHttpClient=");
        outline73.append(this.mOkHttpClient);
        outline73.append(", request=");
        outline73.append(this.request);
        outline73.append('}');
        return outline73.toString();
    }
}
