package com.google.firebase.perf.network;

import android.os.Build.VERSION;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public final class InstrHttpURLConnection extends HttpURLConnection {
    public final InstrURLConnectionBase delegate;

    public InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpURLConnection.getURL());
        this.delegate = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
    }

    public void addRequestProperty(String str, String str2) {
        this.delegate.httpUrlConnection.addRequestProperty(str, str2);
    }

    public void connect() throws IOException {
        this.delegate.connect();
    }

    public void disconnect() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.networkMetricBuilder.setTimeToResponseCompletedMicros(instrURLConnectionBase.timer.getDurationMicros());
        instrURLConnectionBase.networkMetricBuilder.build();
        instrURLConnectionBase.httpUrlConnection.disconnect();
    }

    public boolean equals(Object obj) {
        return this.delegate.httpUrlConnection.equals(obj);
    }

    public boolean getAllowUserInteraction() {
        return this.delegate.httpUrlConnection.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.delegate.httpUrlConnection.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        return this.delegate.getContent();
    }

    public String getContentEncoding() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getContentEncoding();
    }

    public int getContentLength() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getContentLength();
    }

    public long getContentLengthLong() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        if (VERSION.SDK_INT >= 24) {
            return instrURLConnectionBase.httpUrlConnection.getContentLengthLong();
        }
        return 0;
    }

    public String getContentType() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getContentType();
    }

    public long getDate() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.delegate.httpUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.delegate.httpUrlConnection.getDoInput();
    }

    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    public long getExpiration() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getExpiration();
    }

    public String getHeaderField(int i) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getHeaderField(i);
    }

    public long getHeaderFieldDate(String str, long j) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getHeaderFieldKey(i);
    }

    public long getHeaderFieldLong(String str, long j) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        if (VERSION.SDK_INT >= 24) {
            return instrURLConnectionBase.httpUrlConnection.getHeaderFieldLong(str, j);
        }
        return 0;
    }

    public Map<String, List<String>> getHeaderFields() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.delegate.httpUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.delegate.httpUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getLastModified();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    public Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }

    public int getReadTimeout() {
        return this.delegate.httpUrlConnection.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.httpUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.delegate.httpUrlConnection.getRequestProperty(str);
    }

    public int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }

    public URL getURL() {
        return this.delegate.httpUrlConnection.getURL();
    }

    public boolean getUseCaches() {
        return this.delegate.httpUrlConnection.getUseCaches();
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public void setAllowUserInteraction(boolean z) {
        this.delegate.httpUrlConnection.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.delegate.httpUrlConnection.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.delegate.httpUrlConnection.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.delegate.httpUrlConnection.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.delegate.httpUrlConnection.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.delegate.httpUrlConnection.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.delegate.httpUrlConnection.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long j) {
        this.delegate.httpUrlConnection.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.delegate.httpUrlConnection.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.delegate.httpUrlConnection.setReadTimeout(i);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.delegate.httpUrlConnection.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        if (instrURLConnectionBase != null) {
            if ("User-Agent".equalsIgnoreCase(str)) {
                instrURLConnectionBase.networkMetricBuilder.userAgent = str2;
            }
            instrURLConnectionBase.httpUrlConnection.setRequestProperty(str, str2);
            return;
        }
        throw null;
    }

    public void setUseCaches(boolean z) {
        this.delegate.httpUrlConnection.setUseCaches(z);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public boolean usingProxy() {
        return this.delegate.httpUrlConnection.usingProxy();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.delegate.getContent(clsArr);
    }

    public void setFixedLengthStreamingMode(long j) {
        this.delegate.httpUrlConnection.setFixedLengthStreamingMode(j);
    }

    public String getHeaderField(String str) {
        InstrURLConnectionBase instrURLConnectionBase = this.delegate;
        instrURLConnectionBase.updateRequestInfo();
        return instrURLConnectionBase.httpUrlConnection.getHeaderField(str);
    }
}
