package com.mpl.network.modules.request;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Keep
public abstract class MRequest implements Cloneable {
    public static String TAG = "MRequest";
    public byte[] bytes;
    public int connectTimeout;
    public String content;
    public File destFile;
    public String destFileName;
    public long downloadedSize;
    public File file;
    public String host;
    public boolean isCachingRequired;
    public String mAndroidAppVersion;
    public int mChunckDelay;
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
    public int type = 0;
    public Pair<String, File>[] uploadingFiles;
    public List<String> urlPathSegments;
    public int writeTimeout;

    public MRequest() {
        MLog.d(TAG, "MRequest() called");
        if (getHeaders() == null) {
            this.mHeaders = new ArrayList();
        }
        getHeaders().add(new MHeader("User-Agent", String.format(Locale.getDefault(), "mpl-android/%s (RV-%s)", new Object[]{getAndroidAppVersion(), getReactVersion()})));
    }

    public Object clone() {
        return super.clone();
    }

    public String getAndroidAppVersion() {
        return this.mAndroidAppVersion;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public int getChunckDelay() {
        return this.mChunckDelay;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getContent() {
        return this.content;
    }

    public File getDestFile() {
        return this.destFile;
    }

    public String getDestFileName() {
        return this.destFileName;
    }

    public long getDownloadedSize() {
        return this.downloadedSize;
    }

    public File getFile() {
        return this.file;
    }

    public List<MHeader> getHeaders() {
        return this.mHeaders;
    }

    public String getHost() {
        return this.host;
    }

    public OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public int getPingInterval() {
        return this.pingInterval;
    }

    public int getPort() {
        return this.port;
    }

    public Map<String, String> getPostFormParams() {
        return this.mPostFormParams;
    }

    public String getPostJsonObject() {
        return this.postJsonObject;
    }

    public Map<String, String> getQueryParams() {
        return this.mQueryParams;
    }

    public String getReactVersion() {
        return this.mReactVersion;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public Request getRequest() {
        return this.request;
    }

    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    public RequestPriority getRequestPriority() {
        return this.mRequestPriority;
    }

    public RequestType getRequestType() {
        return this.mRequestType;
    }

    public IResponseListener getResponseListener() {
        return this.mResponseListener;
    }

    public String getScheme() {
        return this.scheme;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public Pair<String, File>[] getUploadingFiles() {
        return this.uploadingFiles;
    }

    public String getUrl() {
        return this.mMainUrl;
    }

    public List<String> getUrlPathSegments() {
        return this.urlPathSegments;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public boolean isCachingRequired() {
        return this.isCachingRequired;
    }

    public boolean isRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public boolean isValid() {
        boolean z = true;
        if (!TextUtils.isEmpty(getUrl())) {
            return !TextUtils.isEmpty(getUrl());
        }
        if (TextUtils.isEmpty(this.scheme) || TextUtils.isEmpty(this.host)) {
            z = false;
        }
        return z;
    }

    public abstract OkHttpClient prepareClient();

    public abstract Request prepareRequest();

    public abstract RequestBody prepareRequestBody();

    public void printProtocol(Response response) {
        if (response != null && response.protocol() != null) {
            MLog.d(TAG, "Used Protocol:", response.protocol().toString());
        }
    }

    public abstract String printRequest();

    public void printResponseTime(Response response) {
        if (response != null) {
            MLog.d(TAG, "sentRequestAtMillis:", Long.valueOf(response.sentRequestAtMillis()));
            MLog.d(TAG, "receivedResponseAtMillis:", Long.valueOf(response.receivedResponseAtMillis()));
            MLog.d(TAG, "Process Time for Request:", Long.valueOf(response.receivedResponseAtMillis() - response.sentRequestAtMillis()));
        }
    }

    public void processExtraOnResponse(Response response) {
        if (response != null) {
            MLog.d(TAG, "isRedirect:", Boolean.valueOf(response.isRedirect()));
        }
    }

    public abstract <E> void processResponse(Call call, Response response, IResponseListener<E> iResponseListener);

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Request{mPostFormParams=");
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
        outline73.append(", postJsonObject='");
        GeneratedOutlineSupport.outline99(outline73, this.postJsonObject, ExtendedMessageFormat.QUOTE, ", destFile=");
        outline73.append(this.destFile);
        outline73.append(", destFileName='");
        GeneratedOutlineSupport.outline99(outline73, this.destFileName, ExtendedMessageFormat.QUOTE, ", mHeaders=");
        outline73.append(this.mHeaders);
        outline73.append(", mRequestType=");
        outline73.append(this.mRequestType);
        outline73.append(", mQueryParams=");
        outline73.append(this.mQueryParams);
        outline73.append(", mMainUrl='");
        GeneratedOutlineSupport.outline99(outline73, this.mMainUrl, ExtendedMessageFormat.QUOTE, ", tag=");
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
        outline73.append(", scheme='");
        GeneratedOutlineSupport.outline99(outline73, this.scheme, ExtendedMessageFormat.QUOTE, ", host='");
        GeneratedOutlineSupport.outline99(outline73, this.host, ExtendedMessageFormat.QUOTE, ", port=");
        outline73.append(this.port);
        outline73.append(", isCachingRequired=");
        outline73.append(this.isCachingRequired);
        outline73.append(", downloadedSize=");
        outline73.append(this.downloadedSize);
        outline73.append('}');
        return outline73.toString();
    }
}
