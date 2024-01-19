package com.mpl.network.modules.request;

import a.a.a.a.a.e;
import a.a.a.a.d.b;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.fontbox.cmap.CMapParser;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Keep
public class MOKHttpPutRequest extends MRequest {
    public static final String TAG = "NetworkLib: MOKHttpPutRequest";
    public static final int TYPE_BYTES = 3;
    public static final int TYPE_FILE = 4;
    public static final int TYPE_JSON = 5;
    public static final int TYPE_PARAMS = 1;
    public static final int TYPE_STRING = 2;
    public final MediaType MEDIA_TYPE_JSON;
    public final MediaType MEDIA_TYPE_STREAM;
    public final MediaType MEDIA_TYPE_STRING;

    public static final class Builder {
        public byte[] bytes;
        public int connectTimeout;
        public String content;
        public File destFile;
        public String destFileName;
        public File file;
        public String host;
        public boolean isCachingRequired;
        public String mAndroidAppVersion;
        public List<MHeader> mHeaders;
        public String mMainUrl;
        public OkHttpClient mOkHttpClient;
        public Map<String, String> mPostFarmParams;
        public Map<String, String> mQueryParams;
        public String mReactVersion;
        public RequestPriority mRequestPriority = RequestPriority.HIGH;
        public RequestType mRequestType;
        public IResponseListener mResponseListener;
        public int pingInterval;
        public int port;
        public String postJsonObject;
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

        public MOKHttpPutRequest build() {
            if (this.mResponseListener != null) {
                return new MOKHttpPutRequest(this);
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

        public Builder setBytes(byte[] bArr) {
            this.bytes = bArr;
            return this;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        @Deprecated
        public Builder setConnectTimeout(int i, TimeUnit timeUnit) {
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, timeUnit);
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setDestFile(File file2) {
            this.destFile = file2;
            return this;
        }

        public Builder setDestFileName(String str) {
            this.destFileName = str;
            return this;
        }

        public Builder setFile(File file2) {
            this.file = file2;
            return this;
        }

        public Builder setFormPostParams(Map<String, String> map) {
            Map<String, String> map2 = this.mPostFarmParams;
            if (map2 != null) {
                map2.putAll(map);
            } else {
                this.mPostFarmParams = map;
            }
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
            this.pingInterval = b.a("interval", (long) i, timeUnit);
            return this;
        }

        public Builder setPort(int i) {
            if (this.mMainUrl == null) {
                this.port = i;
                return this;
            }
            throw new RuntimeException("Url is already set");
        }

        public Builder setPostJsonObject(String str) {
            this.postJsonObject = str;
            return this;
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
            this.readTimeout = b.a(Values.TIMEOUT, (long) i, timeUnit);
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
            this.writeTimeout = b.a(Values.TIMEOUT, (long) i, timeUnit);
            return this;
        }
    }

    public MOKHttpPutRequest() {
        this.MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream;charset=utf-8");
        this.MEDIA_TYPE_STRING = MediaType.parse("text/plain;charset=utf-8");
        this.MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
        MLog.d(TAG, "MOKHttpPutRequest() called");
    }

    public MOKHttpPutRequest(Builder builder) {
        this.MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream;charset=utf-8");
        this.MEDIA_TYPE_STRING = MediaType.parse("text/plain;charset=utf-8");
        this.MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
        MLog.d(TAG, "MOKHttpPutRequest() called with: builder = [" + builder + CMapParser.MARK_END_OF_ARRAY);
        this.mPostFormParams = builder.mPostFarmParams;
        this.content = builder.content;
        this.bytes = builder.bytes;
        this.file = builder.file;
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
        this.request = builder.request;
        this.postJsonObject = builder.postJsonObject;
        this.scheme = builder.scheme;
        this.port = builder.port;
        this.host = builder.host;
        this.isCachingRequired = builder.isCachingRequired;
        this.mAndroidAppVersion = builder.mAndroidAppVersion;
        this.mReactVersion = builder.mReactVersion;
        this.mOkHttpClient = e.c().a((MRequest) this);
        validParams();
        this.requestBody = prepareRequestBody();
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
        builder.put(prepareRequestBody());
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
        if (getTag() != null) {
            builder.tag(getTag());
        }
        builder.cacheControl(isCachingRequired() ? CacheControl.FORCE_CACHE : CacheControl.FORCE_NETWORK);
        return builder.build();
    }

    public RequestBody prepareRequestBody() {
        String str;
        MediaType mediaType;
        int i = this.type;
        if (i != 1) {
            if (i == 2) {
                mediaType = this.MEDIA_TYPE_STRING;
                str = this.content;
            } else if (i == 3) {
                return RequestBody.create(this.MEDIA_TYPE_STREAM, this.bytes);
            } else {
                if (i == 4) {
                    return RequestBody.create(this.MEDIA_TYPE_STREAM, this.file);
                }
                mediaType = this.MEDIA_TYPE_JSON;
                str = this.postJsonObject;
            }
            return RequestBody.create(mediaType, str);
        }
        okhttp3.FormBody.Builder builder = new okhttp3.FormBody.Builder();
        Map<String, String> map = this.mPostFormParams;
        if (map != null && !map.isEmpty()) {
            for (Entry next : this.mPostFormParams.entrySet()) {
                builder.add((String) next.getKey(), (String) next.getValue());
            }
        }
        return builder.build();
    }

    public String printRequest() {
        return toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00dc, code lost:
        if (r1 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0104, code lost:
        if (r1 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0127, code lost:
        if (r1 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0129, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E> void processResponse(okhttp3.Call r9, okhttp3.Response r10, com.mpl.network.modules.listeners.IResponseListener<E> r11) {
        /*
            r8 = this;
            r9 = 1000(0x3e8, float:1.401E-42)
            r0 = 1001(0x3e9, float:1.403E-42)
            r1 = 0
            if (r10 == 0) goto L_0x00b8
            okhttp3.Headers r2 = r10.headers()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r3.<init>()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            if (r2 == 0) goto L_0x0039
            int r4 = r2.size()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            if (r4 <= 0) goto L_0x0039
            java.util.Set r4 = r2.names()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
        L_0x0020:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            if (r5 == 0) goto L_0x0039
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r6 = r2.get(r5)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            com.mpl.network.modules.engine.MHeader r7 = new com.mpl.network.modules.engine.MHeader     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r7.<init>(r5, r6)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r3.add(r7)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            goto L_0x0020
        L_0x0039:
            int r2 = r3.size()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            if (r2 <= 0) goto L_0x0042
            r11.onProcessHeader(r3)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
        L_0x0042:
            okhttp3.ResponseBody r1 = r10.body()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            if (r1 == 0) goto L_0x009f
            java.lang.String r0 = r1.string()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r2 = "NetworkLib: MOKHttpPutRequest"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r4 = 0
            java.lang.String r5 = "responseBody: "
            r3[r4] = r5     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r4 = 1
            r3[r4] = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            com.mpl.MLog.i(r2, r3)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.reflect.Type r2 = r11.mType     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r2 != r3) goto L_0x0072
            r11.onResponseSuccess(r0)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
        L_0x0065:
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            okhttp3.internal.Util.closeQuietly(r10)
            return
        L_0x0072:
            java.lang.reflect.Type r2 = r11.mType     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.Class<org.json.JSONObject> r3 = org.json.JSONObject.class
            if (r2 != r3) goto L_0x0081
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
        L_0x007d:
            r11.onResponseSuccess(r2)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            goto L_0x0065
        L_0x0081:
            java.lang.reflect.Type r2 = r11.mType     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.Class<org.json.JSONArray> r3 = org.json.JSONArray.class
            if (r2 != r3) goto L_0x008d
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            goto L_0x007d
        L_0x008d:
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.<init>()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.reflect.Type r3 = r11.mType     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.Object r0 = r2.fromJson(r0, r3)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r11.onResponseSuccess(r0)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r1.close()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            goto L_0x00d3
        L_0x009f:
            com.mpl.network.modules.utils.MException$b r2 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.<init>()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.f966c = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r3 = "Response body  is null."
            r0.<init>(r3)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.f965b = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r0 = "Response body is null due from server"
            r2.f964a = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            com.mpl.network.modules.utils.MException r0 = r2.a()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            goto L_0x00d0
        L_0x00b8:
            com.mpl.network.modules.utils.MException$b r2 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.<init>()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.f966c = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r3 = "Response is null."
            r0.<init>(r3)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            r2.f965b = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            java.lang.String r0 = "Response is null due to server error"
            r2.f964a = r0     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
            com.mpl.network.modules.utils.MException r0 = r2.a()     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
        L_0x00d0:
            r11.onResponseFail(r0)     // Catch:{ IOException -> 0x0107, JSONException -> 0x00e1 }
        L_0x00d3:
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r1 == 0) goto L_0x012c
            goto L_0x0129
        L_0x00df:
            r9 = move-exception
            goto L_0x012d
        L_0x00e1:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            com.mpl.network.modules.utils.MException$b r2 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x00df }
            r2.<init>()     // Catch:{ all -> 0x00df }
            r2.f966c = r9     // Catch:{ all -> 0x00df }
            r2.f965b = r0     // Catch:{ all -> 0x00df }
            java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x00df }
            r2.f964a = r9     // Catch:{ all -> 0x00df }
            com.mpl.network.modules.utils.MException r9 = r2.a()     // Catch:{ all -> 0x00df }
            r11.onResponseFail(r9)     // Catch:{ all -> 0x00df }
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r1 == 0) goto L_0x012c
            goto L_0x0129
        L_0x0107:
            r0 = move-exception
            com.mpl.network.modules.utils.MException$b r2 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x00df }
            r2.<init>()     // Catch:{ all -> 0x00df }
            r2.f966c = r9     // Catch:{ all -> 0x00df }
            r2.f965b = r0     // Catch:{ all -> 0x00df }
            java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x00df }
            r2.f964a = r9     // Catch:{ all -> 0x00df }
            com.mpl.network.modules.utils.MException r9 = r2.a()     // Catch:{ all -> 0x00df }
            r11.onResponseFail(r9)     // Catch:{ all -> 0x00df }
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r1 == 0) goto L_0x012c
        L_0x0129:
            okhttp3.internal.Util.closeQuietly(r10)
        L_0x012c:
            return
        L_0x012d:
            r8.printProtocol(r10)
            r8.printResponseTime(r10)
            r8.processExtraOnResponse(r10)
            if (r1 == 0) goto L_0x013b
            okhttp3.internal.Util.closeQuietly(r10)
        L_0x013b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.request.MOKHttpPutRequest.processResponse(okhttp3.Call, okhttp3.Response, com.mpl.network.modules.listeners.IResponseListener):void");
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MOKHttpPutRequest{MEDIA_TYPE_STREAM=");
        outline73.append(this.MEDIA_TYPE_STREAM);
        outline73.append(", MEDIA_TYPE_STRING=");
        outline73.append(this.MEDIA_TYPE_STRING);
        outline73.append(", mPostFormParams=");
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

    public void validParams() {
        int i;
        Map<String, String> map = this.mPostFormParams;
        if (map == null || map.isEmpty()) {
            i = 0;
        } else {
            this.type = 1;
            i = 1;
        }
        if (this.content != null) {
            this.type = 2;
            i++;
        }
        if (this.bytes != null) {
            this.type = 3;
            i++;
        }
        if (this.file != null) {
            this.type = 4;
            i++;
        }
        if (this.postJsonObject != null) {
            this.type = 5;
            i++;
        }
        if (i <= 0 || i > 1) {
            throw new IllegalArgumentException("the params , content , file , bytes must has one and only one .");
        }
    }
}
