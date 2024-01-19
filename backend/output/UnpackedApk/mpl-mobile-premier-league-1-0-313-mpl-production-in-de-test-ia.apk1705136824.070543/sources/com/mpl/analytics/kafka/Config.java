package com.mpl.analytics.kafka;

import com.mpl.network.modules.engine.MHeader;
import java.util.ArrayList;
import java.util.List;

public final class Config {
    public long clockDrift = 60;
    public boolean isLogEnabled = false;
    public String mAuthToken;
    public int mConnectionTimeOut = 30000;
    public int mEventCount;
    public List<MHeader> mHeaders;
    public String mPostUrl;
    public Callback mResponseCallback;
    public long mSendingIntervalTime = 60000;
    public boolean sendingOnFailure;

    public void addHeader(MHeader mHeader) {
        if (this.mHeaders == null) {
            this.mHeaders = new ArrayList();
        }
        this.mHeaders.add(mHeader);
    }

    public String getAuthToken() {
        return this.mAuthToken;
    }

    public long getClockDrift() {
        return this.clockDrift;
    }

    public int getConnectionTimeOut() {
        return this.mConnectionTimeOut;
    }

    public int getEventCount() {
        return this.mEventCount;
    }

    public List<MHeader> getHeaders() {
        return this.mHeaders;
    }

    public String getPostUrl() {
        return this.mPostUrl;
    }

    public Callback getResponseCallback() {
        return this.mResponseCallback;
    }

    public long getSendingIntervalTime() {
        return this.mSendingIntervalTime;
    }

    public boolean getSendingOnFailure() {
        return this.sendingOnFailure;
    }

    public boolean isLogEnabled() {
        return this.isLogEnabled;
    }

    public void setAuthToken(String str) {
        this.mAuthToken = str;
    }

    public void setClockDrift(long j) {
        this.clockDrift = j;
    }

    public void setConnectionTimeOut(int i) {
        this.mConnectionTimeOut = i;
    }

    public void setEventCount(int i) {
        this.mEventCount = i;
    }

    public void setHeaders(List<MHeader> list) {
        List<MHeader> list2 = this.mHeaders;
        if (list2 != null) {
            list2.addAll(list);
        } else {
            this.mHeaders = list;
        }
    }

    public void setLogEnabled(boolean z) {
        this.isLogEnabled = z;
    }

    public void setPostUrl(String str) {
        this.mPostUrl = str;
    }

    public void setResponseCallback(Callback callback) {
        this.mResponseCallback = callback;
    }

    public void setSendingIntervalTime(long j) {
        this.mSendingIntervalTime = j;
    }

    public void setSendingOnFailure(boolean z) {
        this.sendingOnFailure = z;
    }
}
