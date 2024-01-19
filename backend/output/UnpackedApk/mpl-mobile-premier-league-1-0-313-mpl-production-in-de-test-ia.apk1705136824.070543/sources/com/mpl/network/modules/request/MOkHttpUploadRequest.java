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
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.fontbox.cmap.CMapParser;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Keep
public final class MOkHttpUploadRequest extends MOKHttpPostRequest {
    public static final String TAG = "NetworkLib: MOkHttpUploadRequest";

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
        public Map<String, String> mPostFormParams;
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
        public Pair<String, File>[] uploadingFiles;
        public List<String> urlPathSegments;
        public int writeTimeout;

        private Builder setRequest(Request request2) {
            this.request = request2;
            return this;
        }

        private Builder setRequestBody(RequestBody requestBody2) {
            this.requestBody = requestBody2;
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

        public MOkHttpUploadRequest build() {
            if (this.mResponseListener != null) {
                return new MOkHttpUploadRequest(this);
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

        public Builder setOkHttpClient(OkHttpClient okHttpClient) {
            this.mOkHttpClient = okHttpClient;
            return this;
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

    public MOkHttpUploadRequest(Builder builder) {
        MLog.d(TAG, "MOkHttpUploadRequest() called with: builder = [" + builder + CMapParser.MARK_END_OF_ARRAY);
        this.mPostFormParams = builder.mPostFormParams;
        this.content = builder.content;
        this.bytes = builder.bytes;
        this.file = builder.file;
        this.type = builder.type;
        this.uploadingFiles = builder.uploadingFiles;
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
        this.postJsonObject = builder.postJsonObject;
        this.request = builder.request;
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

    private String guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? Attachment.DEFAULT_CONTENT_TYPE : contentTypeFor;
    }

    public Object clone() {
        throw new CloneNotSupportedException();
    }

    public OkHttpClient prepareClient() {
        return super.prepareClient();
    }

    public RequestBody prepareRequestBody() {
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

    public String printRequest() {
        return toString();
    }

    public <E> void processResponse(Call call, Response response, IResponseListener<E> iResponseListener) {
        super.processResponse(call, response, iResponseListener);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MOkHttpUploadRequest{mPostFormParams=");
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
        if (this.mPostFormParams == null && this.uploadingFiles == null) {
            throw new IllegalArgumentException("mPostFormParams and uploadingFiles can't both null in upload request .");
        }
    }
}
