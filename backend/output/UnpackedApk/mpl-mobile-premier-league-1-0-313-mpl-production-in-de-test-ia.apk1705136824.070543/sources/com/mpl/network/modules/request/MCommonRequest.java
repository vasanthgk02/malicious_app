package com.mpl.network.modules.request;

import a.a.a.a.a.e;
import a.a.a.a.c.a;
import a.a.a.a.d.b;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import io.sentry.Attachment;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Keep
public class MCommonRequest extends MRequest {
    public static final String TAG = "NetworkLib: MCommonRequest";
    public static final int TYPE_BYTES = 3;
    public static final int TYPE_FILE = 4;
    public static final int TYPE_JSON = 5;
    public static final int TYPE_MULTIPART = 6;
    public static final int TYPE_PARAMS = 1;
    public static final int TYPE_STRING = 2;
    public final MediaType MEDIA_TYPE_JSON;
    public final MediaType MEDIA_TYPE_STREAM;
    public final MediaType MEDIA_TYPE_STRING;

    /* renamed from: com.mpl.network.modules.request.MCommonRequest$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$mpl$network$modules$request$RequestType;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.mpl.network.modules.request.RequestType[] r0 = com.mpl.network.modules.request.RequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mpl$network$modules$request$RequestType = r0
                com.mpl.network.modules.request.RequestType r1 = com.mpl.network.modules.request.RequestType.POST     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$mpl$network$modules$request$RequestType     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.mpl.network.modules.request.RequestType r1 = com.mpl.network.modules.request.RequestType.PUT     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r0 = 3
                r1 = 4
                int[] r2 = $SwitchMap$com$mpl$network$modules$request$RequestType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mpl.network.modules.request.RequestType r3 = com.mpl.network.modules.request.RequestType.PATCH     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$com$mpl$network$modules$request$RequestType     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.mpl.network.modules.request.RequestType r3 = com.mpl.network.modules.request.RequestType.DELETE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = $SwitchMap$com$mpl$network$modules$request$RequestType     // Catch:{ NoSuchFieldError -> 0x002c }
                com.mpl.network.modules.request.RequestType r1 = com.mpl.network.modules.request.RequestType.HEAD     // Catch:{ NoSuchFieldError -> 0x002c }
                r1 = 10
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                int[] r0 = $SwitchMap$com$mpl$network$modules$request$RequestType     // Catch:{ NoSuchFieldError -> 0x0034 }
                com.mpl.network.modules.request.RequestType r1 = com.mpl.network.modules.request.RequestType.GET     // Catch:{ NoSuchFieldError -> 0x0034 }
                r1 = 0
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.request.MCommonRequest.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder {
        public byte[] bytes;
        public int connectTimeout;
        public String content;
        public File destFile;
        public String destFileName;
        public long downloadedSize;
        public File file;
        public String host;
        public boolean isCachingRequired;
        public boolean isResume;
        public String mAndroidAppVersion;
        public List<MHeader> mHeaders;
        public String mMainUrl;
        public OkHttpClient mOkHttpClient;
        public Map<String, String> mPostFormParams;
        public Map<String, String> mQueryParams;
        public String mReactVersion;
        public RequestPriority mRequestPriority = RequestPriority.HIGH;
        public RequestType mRequestType = RequestType.GET;
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
        public Pair<String, File>[] uploadingFiles;
        public List<String> urlPathSegments;
        public int writeTimeout;

        public Builder addHeader(MHeader mHeader) {
            if (this.mHeaders == null) {
                this.mHeaders = new ArrayList();
            }
            this.mHeaders.add(mHeader);
            return this;
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

        public Builder addUrlPathSegments(String str) {
            if (this.urlPathSegments == null) {
                this.urlPathSegments = new ArrayList();
            }
            this.urlPathSegments.add(str);
            return this;
        }

        public MCommonRequest build() {
            return new MCommonRequest(this, null);
        }

        public Builder isCacheRequired(boolean z) {
            this.isCachingRequired = z;
            return this;
        }

        public Builder isResume(boolean z) {
            this.isResume = z;
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
            this.connectTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
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

        public Builder setDownloadedSize(long j) {
            this.downloadedSize = j;
            return this;
        }

        public Builder setFile(File file2) {
            this.file = file2;
            return this;
        }

        public Builder setFormPostParams(Map<String, String> map) {
            Map<String, String> map2 = this.mPostFormParams;
            if (map2 != null) {
                map2.putAll(map);
            } else {
                this.mPostFormParams = map;
            }
            return this;
        }

        public Builder setHeaders(List<MHeader> list) {
            List<MHeader> list2 = this.mHeaders;
            if (list2 == null) {
                this.mHeaders = list;
            } else {
                list2.addAll(list);
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

        public Builder setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
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
            this.readTimeout = b.a(Values.TIMEOUT, (long) i, TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder setRequest(Request request2) {
            this.request = request2;
            return this;
        }

        public Builder setRequestBody(RequestBody requestBody2) {
            this.requestBody = requestBody2;
            return this;
        }

        public Builder setRequestPriority(RequestPriority requestPriority) {
            this.mRequestPriority = requestPriority;
            return this;
        }

        public Builder setRequestType(RequestType requestType) {
            this.mRequestType = requestType;
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

        public Builder setUploadingFiles(Pair<String, File>... pairArr) {
            this.uploadingFiles = pairArr;
            return this;
        }

        public Builder setUrl(String str) {
            if (!TextUtils.isEmpty(this.scheme) || !TextUtils.isEmpty(this.host) || this.port != 0) {
                throw new RuntimeException("scheme or host is already set. ");
            }
            this.mMainUrl = str;
            return this;
        }

        public Builder setUrlPathSegments(List<String> list) {
            List<String> list2 = this.urlPathSegments;
            if (list2 == null) {
                this.urlPathSegments = list;
            } else {
                list2.addAll(list);
            }
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

    public MCommonRequest(Builder builder) {
        this.MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream;charset=utf-8");
        this.MEDIA_TYPE_STRING = MediaType.parse("text/plain;charset=utf-8");
        this.MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
        this.mPostFormParams = builder.mPostFormParams;
        this.content = builder.content;
        this.bytes = builder.bytes;
        this.file = builder.file;
        this.type = builder.type;
        this.uploadingFiles = builder.uploadingFiles;
        this.postJsonObject = builder.postJsonObject;
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
        this.mOkHttpClient = builder.mOkHttpClient;
        this.request = builder.request;
        this.scheme = builder.scheme;
        this.host = builder.host;
        this.port = builder.port;
        this.isCachingRequired = builder.isCachingRequired;
        this.downloadedSize = builder.downloadedSize;
        this.mAndroidAppVersion = builder.mAndroidAppVersion;
        this.mReactVersion = builder.mReactVersion;
        this.mOkHttpClient = e.c().a((MRequest) this);
        if (getRequestType() == RequestType.POST || getRequestType() == RequestType.PUT || getRequestType() == RequestType.DELETE || getRequestType() == RequestType.PATCH) {
            validParams();
            this.requestBody = prepareRequestBody();
        }
    }

    public /* synthetic */ MCommonRequest(Builder builder, AnonymousClass1 r2) {
        this(builder);
    }

    private String guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? Attachment.DEFAULT_CONTENT_TYPE : contentTypeFor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void validParams() {
        /*
            r3 = this;
            android.util.Pair<java.lang.String, java.io.File>[] r0 = r3.uploadingFiles
            r1 = 1
            if (r0 == 0) goto L_0x000d
            int r0 = r0.length
            if (r0 <= 0) goto L_0x000d
            r0 = 6
            r3.type = r0
        L_0x000b:
            r0 = 1
            goto L_0x001b
        L_0x000d:
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.mPostFormParams
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001a
            r3.type = r1
            goto L_0x000b
        L_0x001a:
            r0 = 0
        L_0x001b:
            java.lang.String r2 = r3.content
            if (r2 == 0) goto L_0x0024
            r2 = 2
            r3.type = r2
            int r0 = r0 + 1
        L_0x0024:
            byte[] r2 = r3.bytes
            if (r2 == 0) goto L_0x002d
            r2 = 3
            r3.type = r2
            int r0 = r0 + 1
        L_0x002d:
            java.io.File r2 = r3.file
            if (r2 == 0) goto L_0x0036
            r2 = 4
            r3.type = r2
            int r0 = r0 + 1
        L_0x0036:
            java.lang.String r2 = r3.postJsonObject
            if (r2 == 0) goto L_0x003f
            r2 = 5
            r3.type = r2
            int r0 = r0 + 1
        L_0x003f:
            if (r0 <= 0) goto L_0x0044
            if (r0 > r1) goto L_0x0044
            return
        L_0x0044:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "the params , content , file , bytes must has one and only one ."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.request.MCommonRequest.validParams():void");
    }

    public OkHttpClient prepareClient() {
        return getOkHttpClient();
    }

    public Request prepareRequest() {
        HttpUrl httpUrl;
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        int ordinal = getRequestType().ordinal();
        if (ordinal == 10) {
            builder.head();
        } else if (ordinal == 1) {
            builder.post(getRequestBody());
        } else if (ordinal == 2) {
            builder.put(getRequestBody());
        } else if (ordinal == 3) {
            builder.delete(getRequestBody());
        } else if (ordinal != 4) {
            builder.get();
        } else {
            builder.patch(getRequestBody());
        }
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
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("getHeaders: ");
        outline73.append(getHeaders());
        MLog.i(TAG, outline73.toString());
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
        RequestBody requestBody;
        String str;
        MediaType mediaType;
        int i = this.type;
        if (i != 1) {
            if (i == 2) {
                mediaType = this.MEDIA_TYPE_STRING;
                str = this.content;
            } else if (i == 3) {
                requestBody = RequestBody.create(this.MEDIA_TYPE_STREAM, this.bytes);
            } else if (i == 4) {
                requestBody = RequestBody.create(this.MEDIA_TYPE_STREAM, this.file);
            } else if (i != 6) {
                mediaType = this.MEDIA_TYPE_JSON;
                str = this.postJsonObject;
            } else {
                okhttp3.MultipartBody.Builder builder = new okhttp3.MultipartBody.Builder();
                builder.setType(MultipartBody.FORM);
                Map<String, String> map = this.mPostFormParams;
                if (map != null && !map.isEmpty()) {
                    for (String next : this.mPostFormParams.keySet()) {
                        builder.addPart(Headers.of("Content-Disposition", GeneratedOutlineSupport.outline52("form-data; name=\"", next, "\"")), RequestBody.create((MediaType) null, this.mPostFormParams.get(next)));
                    }
                }
                Pair<String, File>[] pairArr = this.uploadingFiles;
                if (pairArr != null) {
                    for (Pair<String, File> pair : pairArr) {
                        File file = (File) pair.second;
                        String name = file.getName();
                        builder.addPart(Headers.of("Content-Disposition", GeneratedOutlineSupport.outline54("form-data; name=\"", (String) pair.first, "\"; filename=\"", name, "\"")), new a(file, guessMimeType(name), getResponseListener()));
                    }
                }
                return builder.build();
            }
            requestBody = RequestBody.create(mediaType, str);
        } else {
            okhttp3.FormBody.Builder builder2 = new okhttp3.FormBody.Builder();
            Map<String, String> map2 = this.mPostFormParams;
            if (map2 != null && !map2.isEmpty()) {
                for (Entry next2 : this.mPostFormParams.entrySet()) {
                    builder2.add((String) next2.getKey(), (String) next2.getValue());
                }
            }
            requestBody = builder2.build();
        }
        return requestBody;
    }

    public String printRequest() {
        return toString();
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r7v7, types: [java.io.Closeable, okhttp3.ResponseBody] */
    /* JADX WARNING: type inference failed for: r22v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r7v8, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r16v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r16v3, types: [java.io.Closeable, okhttp3.ResponseBody] */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r8v12, types: [okio.BufferedSource] */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: type inference failed for: r22v8 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r22v11 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r6v19, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r22v12 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: type inference failed for: r22v13 */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* JADX WARNING: type inference failed for: r7v22 */
    /* JADX WARNING: type inference failed for: r7v23 */
    /* JADX WARNING: type inference failed for: r7v24 */
    /* JADX WARNING: type inference failed for: r7v25 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r7v27 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r7v29 */
    /* JADX WARNING: type inference failed for: r7v30 */
    /* JADX WARNING: type inference failed for: r7v31 */
    /* JADX WARNING: type inference failed for: r7v32 */
    /* JADX WARNING: type inference failed for: r7v33 */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r7v35 */
    /* JADX WARNING: type inference failed for: r7v36 */
    /* JADX WARNING: type inference failed for: r7v37 */
    /* JADX WARNING: type inference failed for: r22v14 */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r16v7 */
    /* JADX WARNING: type inference failed for: r16v8 */
    /* JADX WARNING: type inference failed for: r16v9 */
    /* JADX WARNING: type inference failed for: r7v38 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r8v26 */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r13v14 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r8v29 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r8v31 */
    /* JADX WARNING: type inference failed for: r13v15 */
    /* JADX WARNING: type inference failed for: r13v16 */
    /* JADX WARNING: type inference failed for: r13v17 */
    /* JADX WARNING: type inference failed for: r13v18 */
    /* JADX WARNING: type inference failed for: r22v15 */
    /* JADX WARNING: type inference failed for: r22v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01c5, code lost:
        r2 = r25.headers();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01d1, code lost:
        r4 = r2.names().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01dd, code lost:
        if (r4.hasNext() != false) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01df, code lost:
        r5 = r4.next();
        r3.a(r5, r2.get(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0202, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0205, code lost:
        if (r7 != 0) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0210, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0215, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x037d, code lost:
        if (r7 == 0) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x03d0, code lost:
        if (r7 == 0) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0422, code lost:
        if (r7 == 0) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e1, code lost:
        r13 = r6;
        r22 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0146, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0147, code lost:
        r22 = r8;
        r16 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0197, code lost:
        if (r7 != 0) goto L_0x0424;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v3
      assigns: []
      uses: []
      mth insns count: 430
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c5 A[Catch:{ all -> 0x0209 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0146 A[ExcHandler: all (th java.lang.Throwable), PHI: r8 
      PHI: (r8v13 ?) = (r8v18 ?), (r8v19 ?), (r8v20 ?), (r8v22 ?), (r8v23 ?), (r8v24 ?), (r8v25 ?), (r8v26 ?), (r8v27 ?), (r8v28 ?), (r8v29 ?), (r8v30 ?), (r8v31 ?) binds: [B:13:0x004d, B:21:0x0061, B:34:0x008a, B:32:0x0086, B:27:0x0078, B:25:0x0072, B:26:?, B:17:0x0057, B:18:?, B:40:0x009d, B:41:?, B:43:0x00b7, B:44:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:21:0x0061] */
    /* JADX WARNING: Unknown variable types count: 34 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E> void processResponse(okhttp3.Call r24, okhttp3.Response r25, com.mpl.network.modules.listeners.IResponseListener<E> r26) {
        /*
            r23 = this;
            r1 = r23
            r2 = r25
            r9 = r26
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r3 = "Response is null from server"
            java.io.File r4 = r23.getDestFile()
            java.lang.String r5 = "Response body is null"
            r11 = 2
            r6 = 1001(0x3e9, float:1.403E-42)
            r7 = 0
            java.lang.String r12 = "NetworkLib: MCommonRequest"
            r13 = 1
            r14 = 0
            if (r4 == 0) goto L_0x0260
            java.io.File r4 = r23.getDestFile()
            boolean r4 = r4.exists()
            if (r4 == 0) goto L_0x0260
            java.io.File r3 = r23.getDestFile()
            if (r3 == 0) goto L_0x0219
            java.io.File r3 = r23.getDestFile()
            boolean r3 = r3.exists()
            if (r3 == 0) goto L_0x0219
            java.io.File r15 = r23.getDestFile()     // Catch:{ IOException -> 0x01a1, all -> 0x019d }
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ IOException -> 0x01a1, all -> 0x019d }
            java.lang.String r4 = "downloadedFile: "
            r3[r14] = r4     // Catch:{ IOException -> 0x01a1, all -> 0x019d }
            r3[r13] = r15     // Catch:{ IOException -> 0x01a1, all -> 0x019d }
            com.mpl.MLog.i(r12, r3)     // Catch:{ IOException -> 0x01a1, all -> 0x019d }
            okhttp3.ResponseBody r16 = r25.body()     // Catch:{ IOException -> 0x01a1, all -> 0x019d }
            if (r16 == 0) goto L_0x0155
            okio.BufferedSource r8 = r16.source()     // Catch:{ IOException -> 0x0152 }
            long r3 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0061
            long r3 = r1.downloadedSize     // Catch:{ IOException -> 0x005d, all -> 0x0146 }
            r8.skip(r3)     // Catch:{ IOException -> 0x005d, all -> 0x0146 }
            goto L_0x0061
        L_0x005d:
            r0 = move-exception
            r7 = r8
            goto L_0x0153
        L_0x0061:
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            java.io.InputStream r3 = r16.byteStream()     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            r7.<init>(r3)     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            long r3 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            int r17 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r17 <= 0) goto L_0x0078
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005d, all -> 0x0146 }
            r3.<init>(r15, r13)     // Catch:{ IOException -> 0x005d, all -> 0x0146 }
            goto L_0x007d
        L_0x0078:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            r3.<init>(r15, r14)     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
        L_0x007d:
            r4 = r3
            long r17 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            int r3 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x008a
            long r5 = r23.getDownloadedSize()     // Catch:{ IOException -> 0x005d, all -> 0x0146 }
        L_0x008a:
            long r17 = r16.contentLength()     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
        L_0x0092:
            int r10 = r7.read(r3)     // Catch:{ IOException -> 0x014b, all -> 0x0146 }
            r13 = -1
            if (r10 == r13) goto L_0x00ec
            r19 = r12
            long r11 = (long) r10
            long r11 = r11 + r5
            r4.write(r3, r14, r10)     // Catch:{ IOException -> 0x00e6, all -> 0x0146 }
            r5 = 100
            long r5 = r5 * r11
            long r5 = r5 / r17
            int r6 = (int) r5     // Catch:{ IOException -> 0x00e6, all -> 0x0146 }
            r5 = 2
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x00e6, all -> 0x0146 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x00e6, all -> 0x0146 }
            r10[r14] = r5     // Catch:{ IOException -> 0x00e6, all -> 0x0146 }
            java.lang.String r5 = "% downloaded"
            r6 = 1
            r10[r6] = r5     // Catch:{ IOException -> 0x00e6, all -> 0x0146 }
            r6 = r19
            com.mpl.MLog.i(r6, r10)     // Catch:{ IOException -> 0x00e0, all -> 0x0146 }
            int r5 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            r19 = r3
            if (r5 != 0) goto L_0x00c2
            r10 = 1
            goto L_0x00c3
        L_0x00c2:
            r10 = 0
        L_0x00c3:
            r3 = r26
            r20 = r4
            r4 = r11
            r13 = r6
            r21 = r7
            r6 = r17
            r22 = r8
            r8 = r10
            r3.progressResponse(r4, r6, r8)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r5 = r11
            r12 = r13
            r3 = r19
            r4 = r20
            r7 = r21
            r8 = r22
            r11 = 2
            r13 = 1
            goto L_0x0092
        L_0x00e0:
            r0 = move-exception
            r13 = r6
            r22 = r8
            goto L_0x014f
        L_0x00e6:
            r0 = move-exception
            r22 = r8
            r13 = r19
            goto L_0x014f
        L_0x00ec:
            r22 = r8
            r13 = r12
            okhttp3.Headers r3 = r25.headers()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r4.<init>()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            if (r3 == 0) goto L_0x0121
            int r5 = r3.size()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            if (r5 <= 0) goto L_0x0121
            java.util.Set r5 = r3.names()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
        L_0x0108:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            if (r6 == 0) goto L_0x0121
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            java.lang.String r7 = r3.get(r6)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            com.mpl.network.modules.engine.MHeader r8 = new com.mpl.network.modules.engine.MHeader     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r8.<init>(r6, r7)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r4.add(r8)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            goto L_0x0108
        L_0x0121:
            int r3 = r4.size()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            if (r3 <= 0) goto L_0x012a
            r9.onProcessHeader(r4)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
        L_0x012a:
            java.lang.reflect.Type r3 = r9.mType     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            java.lang.Class<java.io.File> r4 = java.io.File.class
            if (r3 != r4) goto L_0x0133
            r9.onResponseSuccess(r15)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
        L_0x0133:
            java.lang.reflect.Type r3 = r9.mType     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            if (r3 != r0) goto L_0x013e
            java.lang.String r0 = r15.getAbsolutePath()     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
            r9.onResponseSuccess(r0)     // Catch:{ IOException -> 0x0144, all -> 0x0141 }
        L_0x013e:
            r7 = r22
            goto L_0x0192
        L_0x0141:
            r0 = move-exception
            goto L_0x020c
        L_0x0144:
            r0 = move-exception
            goto L_0x014f
        L_0x0146:
            r0 = move-exception
            r22 = r8
            goto L_0x020c
        L_0x014b:
            r0 = move-exception
            r22 = r8
            r13 = r12
        L_0x014f:
            r7 = r22
            goto L_0x01a5
        L_0x0152:
            r0 = move-exception
        L_0x0153:
            r13 = r12
            goto L_0x01a5
        L_0x0155:
            r13 = r12
            com.mpl.network.modules.utils.MException$b r0 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x019b }
            r0.<init>()     // Catch:{ IOException -> 0x019b }
            okhttp3.Headers r3 = r25.headers()     // Catch:{ IOException -> 0x019b }
            if (r3 == 0) goto L_0x0183
            int r4 = r3.size()     // Catch:{ IOException -> 0x019b }
            if (r4 <= 0) goto L_0x0183
            java.util.Set r4 = r3.names()     // Catch:{ IOException -> 0x019b }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x019b }
        L_0x016f:
            boolean r6 = r4.hasNext()     // Catch:{ IOException -> 0x019b }
            if (r6 == 0) goto L_0x0183
            java.lang.Object r6 = r4.next()     // Catch:{ IOException -> 0x019b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x019b }
            java.lang.String r8 = r3.get(r6)     // Catch:{ IOException -> 0x019b }
            r0.a(r6, r8)     // Catch:{ IOException -> 0x019b }
            goto L_0x016f
        L_0x0183:
            int r3 = r25.code()     // Catch:{ IOException -> 0x019b }
            r0.f966c = r3     // Catch:{ IOException -> 0x019b }
            r0.f964a = r5     // Catch:{ IOException -> 0x019b }
            com.mpl.network.modules.utils.MException r0 = r0.a()     // Catch:{ IOException -> 0x019b }
            r9.onResponseFail(r0)     // Catch:{ IOException -> 0x019b }
        L_0x0192:
            if (r16 == 0) goto L_0x0197
            okhttp3.internal.Util.closeQuietly(r16)
        L_0x0197:
            if (r7 == 0) goto L_0x0427
            goto L_0x0424
        L_0x019b:
            r0 = move-exception
            goto L_0x01a5
        L_0x019d:
            r0 = move-exception
            r22 = r7
            goto L_0x020e
        L_0x01a1:
            r0 = move-exception
            r13 = r12
            r16 = r7
        L_0x01a5:
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0209 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0209 }
            r4.<init>()     // Catch:{ all -> 0x0209 }
            java.lang.String r5 = "Exception in writting file: "
            r4.append(r5)     // Catch:{ all -> 0x0209 }
            r4.append(r0)     // Catch:{ all -> 0x0209 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0209 }
            r3[r14] = r4     // Catch:{ all -> 0x0209 }
            com.mpl.MLog.e(r13, r3)     // Catch:{ all -> 0x0209 }
            com.mpl.network.modules.utils.MException$b r3 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x0209 }
            r3.<init>()     // Catch:{ all -> 0x0209 }
            if (r2 == 0) goto L_0x01ed
            okhttp3.Headers r2 = r25.headers()     // Catch:{ all -> 0x0209 }
            if (r2 == 0) goto L_0x01ed
            int r4 = r2.size()     // Catch:{ all -> 0x0209 }
            if (r4 <= 0) goto L_0x01ed
            java.util.Set r4 = r2.names()     // Catch:{ all -> 0x0209 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0209 }
        L_0x01d9:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0209 }
            if (r5 == 0) goto L_0x01ed
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0209 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0209 }
            java.lang.String r6 = r2.get(r5)     // Catch:{ all -> 0x0209 }
            r3.a(r5, r6)     // Catch:{ all -> 0x0209 }
            goto L_0x01d9
        L_0x01ed:
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.f966c = r2     // Catch:{ all -> 0x0209 }
            r3.f965b = r0     // Catch:{ all -> 0x0209 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0209 }
            r3.f964a = r0     // Catch:{ all -> 0x0209 }
            com.mpl.network.modules.utils.MException r0 = r3.a()     // Catch:{ all -> 0x0209 }
            r9.onResponseFail(r0)     // Catch:{ all -> 0x0209 }
            if (r16 == 0) goto L_0x0205
            okhttp3.internal.Util.closeQuietly(r16)
        L_0x0205:
            if (r7 == 0) goto L_0x0427
            goto L_0x0424
        L_0x0209:
            r0 = move-exception
            r22 = r7
        L_0x020c:
            r7 = r16
        L_0x020e:
            if (r7 == 0) goto L_0x0213
            okhttp3.internal.Util.closeQuietly(r7)
        L_0x0213:
            if (r22 == 0) goto L_0x0218
            okhttp3.internal.Util.closeQuietly(r22)
        L_0x0218:
            throw r0
        L_0x0219:
            com.mpl.network.modules.utils.MException$b r0 = new com.mpl.network.modules.utils.MException$b
            r0.<init>()
            if (r2 == 0) goto L_0x0248
            okhttp3.Headers r2 = r25.headers()
            if (r2 == 0) goto L_0x0248
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0248
            java.util.Set r3 = r2.names()
            java.util.Iterator r3 = r3.iterator()
        L_0x0234:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0248
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r2.get(r4)
            r0.a(r4, r5)
            goto L_0x0234
        L_0x0248:
            r0.f966c = r6
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "File path or file name is null."
            r2.<init>(r3)
            r0.f965b = r2
            java.lang.String r2 = "Please provide destination file path and destination file name for saving file"
            r0.f964a = r2
            com.mpl.network.modules.utils.MException r0 = r0.a()
            r9.onResponseFail(r0)
            goto L_0x0427
        L_0x0260:
            r13 = r12
            if (r2 == 0) goto L_0x0333
            okhttp3.ResponseBody r7 = r25.body()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r7 == 0) goto L_0x02f4
            java.lang.String r3 = r7.string()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r5 = "responseBody: "
            r4[r14] = r5     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r5 = 1
            r4[r5] = r3     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            com.mpl.MLog.i(r13, r4)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            okhttp3.Headers r4 = r25.headers()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r5.<init>()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r4 == 0) goto L_0x02ac
            int r6 = r4.size()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r6 <= 0) goto L_0x02ac
            java.util.Set r6 = r4.names()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x0293:
            boolean r8 = r6.hasNext()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r8 == 0) goto L_0x02ac
            java.lang.Object r8 = r6.next()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r10 = r4.get(r8)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            com.mpl.network.modules.engine.MHeader r11 = new com.mpl.network.modules.engine.MHeader     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r11.<init>(r8, r10)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r5.add(r11)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x0293
        L_0x02ac:
            int r4 = r5.size()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r4 <= 0) goto L_0x02b5
            r9.onProcessHeader(r5)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x02b5:
            java.lang.reflect.Type r4 = r9.mType     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r4 != r0) goto L_0x02c9
            r9.onResponseSuccess(r3)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x02bc:
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            okhttp3.internal.Util.closeQuietly(r7)
            return
        L_0x02c9:
            java.lang.reflect.Type r0 = r9.mType     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.Class<org.json.JSONObject> r4 = org.json.JSONObject.class
            if (r0 != r4) goto L_0x02d8
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x02d4:
            r9.onResponseSuccess(r0)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x02bc
        L_0x02d8:
            java.lang.reflect.Type r0 = r9.mType     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.Class<org.json.JSONArray> r4 = org.json.JSONArray.class
            if (r0 != r4) goto L_0x02e4
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x02d4
        L_0x02e4:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.<init>()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.reflect.Type r4 = r9.mType     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.Object r0 = r0.fromJson(r3, r4)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r9.onResponseSuccess(r0)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x0374
        L_0x02f4:
            com.mpl.network.modules.utils.MException$b r0 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.<init>()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            okhttp3.Headers r3 = r25.headers()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r3 == 0) goto L_0x0321
            int r4 = r3.size()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r4 <= 0) goto L_0x0321
            java.util.Set r4 = r3.names()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x030d:
            boolean r8 = r4.hasNext()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r8 == 0) goto L_0x0321
            java.lang.Object r8 = r4.next()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r10 = r3.get(r8)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.a(r8, r10)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x030d
        L_0x0321:
            r0.f966c = r6     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.f965b = r3     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r3 = "Response body is null from server"
            r0.f964a = r3     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            com.mpl.network.modules.utils.MException r0 = r0.a()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x0371
        L_0x0333:
            com.mpl.network.modules.utils.MException$b r0 = new com.mpl.network.modules.utils.MException$b     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.<init>()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r2 == 0) goto L_0x0362
            okhttp3.Headers r4 = r25.headers()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r4 == 0) goto L_0x0362
            int r5 = r4.size()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r5 <= 0) goto L_0x0362
            java.util.Set r5 = r4.names()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x034e:
            boolean r8 = r5.hasNext()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            if (r8 == 0) goto L_0x0362
            java.lang.Object r8 = r5.next()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.String r10 = r4.get(r8)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.a(r8, r10)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            goto L_0x034e
        L_0x0362:
            r0.f966c = r6     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.f965b = r4     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            r0.f964a = r3     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
            com.mpl.network.modules.utils.MException r0 = r0.a()     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x0371:
            r9.onResponseFail(r0)     // Catch:{ IOException -> 0x03d3, JSONException -> 0x0384 }
        L_0x0374:
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r7 == 0) goto L_0x0427
            goto L_0x0424
        L_0x0381:
            r0 = move-exception
            goto L_0x0428
        L_0x0384:
            r0 = move-exception
            com.mpl.network.modules.utils.MException$b r3 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x0381 }
            r3.<init>()     // Catch:{ all -> 0x0381 }
            if (r2 == 0) goto L_0x03b4
            okhttp3.Headers r4 = r25.headers()     // Catch:{ all -> 0x0381 }
            if (r4 == 0) goto L_0x03b4
            int r5 = r4.size()     // Catch:{ all -> 0x0381 }
            if (r5 <= 0) goto L_0x03b4
            java.util.Set r5 = r4.names()     // Catch:{ all -> 0x0381 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0381 }
        L_0x03a0:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0381 }
            if (r6 == 0) goto L_0x03b4
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0381 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0381 }
            java.lang.String r8 = r4.get(r6)     // Catch:{ all -> 0x0381 }
            r3.a(r6, r8)     // Catch:{ all -> 0x0381 }
            goto L_0x03a0
        L_0x03b4:
            r4 = 1000(0x3e8, float:1.401E-42)
            r3.f966c = r4     // Catch:{ all -> 0x0381 }
            r3.f965b = r0     // Catch:{ all -> 0x0381 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0381 }
            r3.f964a = r0     // Catch:{ all -> 0x0381 }
            com.mpl.network.modules.utils.MException r0 = r3.a()     // Catch:{ all -> 0x0381 }
            r9.onResponseFail(r0)     // Catch:{ all -> 0x0381 }
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r7 == 0) goto L_0x0427
            goto L_0x0424
        L_0x03d3:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0381 }
            com.mpl.network.modules.utils.MException$b r3 = new com.mpl.network.modules.utils.MException$b     // Catch:{ all -> 0x0381 }
            r3.<init>()     // Catch:{ all -> 0x0381 }
            if (r2 == 0) goto L_0x0406
            okhttp3.Headers r4 = r25.headers()     // Catch:{ all -> 0x0381 }
            if (r4 == 0) goto L_0x0406
            int r5 = r4.size()     // Catch:{ all -> 0x0381 }
            if (r5 <= 0) goto L_0x0406
            java.util.Set r5 = r4.names()     // Catch:{ all -> 0x0381 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0381 }
        L_0x03f2:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0381 }
            if (r6 == 0) goto L_0x0406
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0381 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0381 }
            java.lang.String r8 = r4.get(r6)     // Catch:{ all -> 0x0381 }
            r3.a(r6, r8)     // Catch:{ all -> 0x0381 }
            goto L_0x03f2
        L_0x0406:
            r4 = 1000(0x3e8, float:1.401E-42)
            r3.f966c = r4     // Catch:{ all -> 0x0381 }
            r3.f965b = r0     // Catch:{ all -> 0x0381 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0381 }
            r3.f964a = r0     // Catch:{ all -> 0x0381 }
            com.mpl.network.modules.utils.MException r0 = r3.a()     // Catch:{ all -> 0x0381 }
            r9.onResponseFail(r0)     // Catch:{ all -> 0x0381 }
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r7 == 0) goto L_0x0427
        L_0x0424:
            okhttp3.internal.Util.closeQuietly(r7)
        L_0x0427:
            return
        L_0x0428:
            r1.printProtocol(r2)
            r1.printResponseTime(r2)
            r1.processExtraOnResponse(r2)
            if (r7 == 0) goto L_0x0436
            okhttp3.internal.Util.closeQuietly(r7)
        L_0x0436:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.network.modules.request.MCommonRequest.processResponse(okhttp3.Call, okhttp3.Response, com.mpl.network.modules.listeners.IResponseListener):void");
    }
}
