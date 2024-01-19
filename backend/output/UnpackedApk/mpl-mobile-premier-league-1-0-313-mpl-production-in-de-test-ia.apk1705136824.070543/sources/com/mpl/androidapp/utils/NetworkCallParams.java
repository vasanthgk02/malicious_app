package com.mpl.androidapp.utils;

import com.mpl.network.modules.engine.MHeader;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class NetworkCallParams {
    public boolean cacheControl;
    public int connectionTimeOut;
    public String content;
    public String destinationFileName;
    public String destinationFilePath;
    public String filePath;
    public String host;
    public List<MHeader> mHeaders;
    public IdentityHashMap<String, String> mMultiPartParams;
    public IdentityHashMap<String, String> mQueryParams;
    public String mRequestBody;
    public String pathSegment;
    public int pingInterval;
    public int port;
    public int priority;
    public int readTimeOut;
    public String requestType;
    public boolean retryOption;
    public String scheme;
    public List<SendingFilePath> sendingFilePath;
    public long startingTime;
    public String tag;
    public String url;
    public int writeTimeOut;

    public static final class Builder {
        public boolean cacheControl;
        public int connectionTimeOut;
        public String content;
        public String destinationFileName;
        public String destinationFilePath;
        public String filePath;
        public String host;
        public List<MHeader> mHeaders = new ArrayList();
        public IdentityHashMap<String, String> mMultiPartParams;
        public IdentityHashMap<String, String> mQueryParams;
        public String mRequestBody;
        public String pathSegment;
        public int pingInterval;
        public int port;
        public int priority;
        public int readTimeOut;
        public String requestType;
        public boolean retryOption;
        public String scheme;
        public List<SendingFilePath> sendingFilePath;
        public String tag;
        public String url;
        public int writeTimeOut;

        public Builder addHeader(MHeader mHeader) {
            List<MHeader> list = this.mHeaders;
            if (list == null) {
                this.mHeaders = new ArrayList();
            } else {
                list.add(mHeader);
            }
            return this;
        }

        public NetworkCallParams build() {
            return new NetworkCallParams(this);
        }

        public Builder setCacheControl(boolean z) {
            this.cacheControl = z;
            return this;
        }

        public Builder setConnectionTimeOut(int i) {
            this.connectionTimeOut = i;
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setDestinationFileName(String str) {
            this.destinationFileName = str;
            return this;
        }

        public Builder setDestinationFilePath(String str) {
            this.destinationFilePath = str;
            return this;
        }

        public Builder setFilePath(String str) {
            this.filePath = str;
            return this;
        }

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setMHeaders(List<MHeader> list) {
            List<MHeader> list2 = this.mHeaders;
            if (list2 == null) {
                this.mHeaders = list;
            } else {
                list2.addAll(list);
            }
            return this;
        }

        public Builder setMMultiPartParams(IdentityHashMap<String, String> identityHashMap) {
            this.mMultiPartParams = identityHashMap;
            return this;
        }

        public Builder setMQueryParams(IdentityHashMap<String, String> identityHashMap) {
            this.mQueryParams = identityHashMap;
            return this;
        }

        public Builder setMRequestBody(String str) {
            this.mRequestBody = str;
            return this;
        }

        public Builder setPathSegment(String str) {
            this.pathSegment = str;
            return this;
        }

        public Builder setPingInterval(int i) {
            this.pingInterval = i;
            return this;
        }

        public Builder setPort(int i) {
            this.port = i;
            return this;
        }

        public Builder setPriority(int i) {
            this.priority = i;
            return this;
        }

        public Builder setReadTimeOut(int i) {
            this.readTimeOut = i;
            return this;
        }

        public Builder setRequestType(String str) {
            this.requestType = str;
            return this;
        }

        public Builder setRetryOption(boolean z) {
            this.retryOption = z;
            return this;
        }

        public Builder setScheme(String str) {
            this.scheme = str;
            return this;
        }

        public Builder setSendingFilePath(List<SendingFilePath> list) {
            this.sendingFilePath = list;
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setWriteTimeOut(int i) {
            this.writeTimeOut = i;
            return this;
        }
    }

    public static class SendingFilePath {
        public String filePath;
        public String headerName;

        public String getFilePath() {
            return this.filePath;
        }

        public String getHeaderName() {
            return this.headerName;
        }

        public void setFilePath(String str) {
            this.filePath = str;
        }

        public void setHeaderName(String str) {
            this.headerName = str;
        }
    }

    public int getConnectionTimeOut() {
        return this.connectionTimeOut;
    }

    public String getContent() {
        return this.content;
    }

    public String getDestinationFileName() {
        return this.destinationFileName;
    }

    public String getDestinationFilePath() {
        return this.destinationFilePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public List<MHeader> getHeaders() {
        if (this.mHeaders == null) {
            this.mHeaders = new ArrayList();
        }
        this.mHeaders.addAll(CommonUtils.getCommonHeaders());
        return this.mHeaders;
    }

    public String getHost() {
        return this.host;
    }

    public IdentityHashMap<String, String> getMultiPartParams() {
        return this.mMultiPartParams;
    }

    public String getPathSegment() {
        return this.pathSegment;
    }

    public int getPingInterval() {
        return this.pingInterval;
    }

    public int getPort() {
        return this.port;
    }

    public int getPriority() {
        return this.priority;
    }

    public IdentityHashMap<String, String> getQueryParams() {
        return this.mQueryParams;
    }

    public int getReadTimeOut() {
        return this.readTimeOut;
    }

    public String getRequestBody() {
        return this.mRequestBody;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getScheme() {
        return this.scheme;
    }

    public List<SendingFilePath> getSendingFilePath() {
        return this.sendingFilePath;
    }

    public long getStartingTime() {
        return this.startingTime;
    }

    public String getTag() {
        return this.tag;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public boolean isCacheControl() {
        return this.cacheControl;
    }

    public boolean isRetryOption() {
        return this.retryOption;
    }

    public void setCacheControl(boolean z) {
        this.cacheControl = z;
    }

    public void setConnectionTimeOut(int i) {
        this.connectionTimeOut = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDestinationFileName(String str) {
        this.destinationFileName = str;
    }

    public void setDestinationFilePath(String str) {
        this.destinationFilePath = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setHeaders(List<MHeader> list) {
        this.mHeaders = list;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setMultiPartParams(IdentityHashMap<String, String> identityHashMap) {
        this.mMultiPartParams = identityHashMap;
    }

    public void setPathSegment(String str) {
        this.pathSegment = str;
    }

    public void setPingInterval(int i) {
        this.pingInterval = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setQueryParams(IdentityHashMap<String, String> identityHashMap) {
        this.mQueryParams = identityHashMap;
    }

    public void setReadTimeOut(int i) {
        this.readTimeOut = i;
    }

    public void setRequestBody(String str) {
        this.mRequestBody = str;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public void setRetryOption(boolean z) {
        this.retryOption = z;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSendingFilePath(List<SendingFilePath> list) {
        this.sendingFilePath = list;
    }

    public void setStartingTime(long j) {
        this.startingTime = j;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWriteTimeOut(int i) {
        this.writeTimeOut = i;
    }

    public NetworkCallParams(Builder builder) {
        setUrl(builder.url);
        setRequestType(builder.requestType);
        setPathSegment(builder.pathSegment);
        setConnectionTimeOut(builder.connectionTimeOut);
        setReadTimeOut(builder.readTimeOut);
        setWriteTimeOut(builder.writeTimeOut);
        setRetryOption(builder.retryOption);
        setPingInterval(builder.pingInterval);
        setCacheControl(builder.cacheControl);
        setScheme(builder.scheme);
        setHost(builder.host);
        setPort(builder.port);
        setDestinationFilePath(builder.destinationFilePath);
        setDestinationFileName(builder.destinationFileName);
        setContent(builder.content);
        setSendingFilePath(builder.sendingFilePath);
        setHeaders(builder.mHeaders);
        setQueryParams(builder.mQueryParams);
        setMultiPartParams(builder.mMultiPartParams);
        setRequestBody(builder.mRequestBody);
        setFilePath(builder.filePath);
        setPriority(builder.priority);
        setTag(builder.tag);
    }
}
