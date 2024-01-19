package com.freshchat.consumer.sdk.beans.config;

public class RefreshIntervals {
    public static final long MAX_REMOTE_CONFIG_FETCH_INTERVAL = 3600000;
    public long activeConvMaxFetchInterval;
    public long activeConvMinFetchInterval;
    public long channelsFetchIntervalLaidback;
    public long channelsFetchIntervalNormal;
    public long faqFetchIntervalLaidback;
    public long faqFetchIntervalNormal;
    public long msgFetchIntervalLaidback;
    public long msgFetchIntervalNormal;
    public long remoteConfigFetchInterval;
    public long responseTimeExpectationsFetchInterval;

    public long getActiveConvMaxFetchInterval() {
        return this.activeConvMaxFetchInterval;
    }

    public long getActiveConvMinFetchInterval() {
        return this.activeConvMinFetchInterval;
    }

    public long getChannelsFetchIntervalLaidback() {
        return this.channelsFetchIntervalLaidback;
    }

    public long getChannelsFetchIntervalNormal() {
        return this.channelsFetchIntervalNormal;
    }

    public long getFaqFetchIntervalLaidback() {
        return this.faqFetchIntervalLaidback;
    }

    public long getFaqFetchIntervalNormal() {
        return this.faqFetchIntervalNormal;
    }

    public long getMsgFetchIntervalLaidback() {
        return this.msgFetchIntervalLaidback;
    }

    public long getMsgFetchIntervalNormal() {
        return this.msgFetchIntervalNormal;
    }

    public long getRemoteConfigFetchInterval() {
        return Math.min(this.remoteConfigFetchInterval, 3600000);
    }

    public long getResponseTimeExpectationsFetchInterval() {
        return this.responseTimeExpectationsFetchInterval;
    }

    public void setActiveConvMaxFetchInterval(long j) {
        this.activeConvMaxFetchInterval = j;
    }

    public void setActiveConvMinFetchInterval(long j) {
        this.activeConvMinFetchInterval = j;
    }

    public void setChannelsFetchIntervalLaidback(long j) {
        this.channelsFetchIntervalLaidback = j;
    }

    public void setChannelsFetchIntervalNormal(long j) {
        this.channelsFetchIntervalNormal = j;
    }

    public void setFaqFetchIntervalLaidback(long j) {
        this.faqFetchIntervalLaidback = j;
    }

    public void setFaqFetchIntervalNormal(long j) {
        this.faqFetchIntervalNormal = j;
    }

    public void setMsgFetchIntervalLaidback(long j) {
        this.msgFetchIntervalLaidback = j;
    }

    public void setMsgFetchIntervalNormal(long j) {
        this.msgFetchIntervalNormal = j;
    }

    public void setRemoteConfigFetchInterval(long j) {
        this.remoteConfigFetchInterval = Math.min(j, 3600000);
    }

    public void setResponseTimeExpectationsFetchInterval(long j) {
        this.responseTimeExpectationsFetchInterval = j;
    }
}
