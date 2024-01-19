package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;

public class ChannelResponseTime {
    public long channelId;
    @SerializedName("customRespMsg")
    public String customResponseTimeMessage;
    public long responseTime;
    public ResponseTimeType responseTimeType;

    public enum ResponseTimeType {
        CURRENT_AVG,
        LAST_WEEK_AVG,
        CUSTOM_RESPONSE,
        ALL_MEMBERS_AWAY_RESPONSE
    }

    public ChannelResponseTime(long j, long j2) {
        this.channelId = j;
        this.responseTime = j2;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCustomResponseTimeMessage() {
        return this.customResponseTimeMessage;
    }

    public long getResponseTime() {
        return this.responseTime;
    }

    public ResponseTimeType getResponseTimeType() {
        return this.responseTimeType;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setCustomResponseTimeMessage(String str) {
        this.customResponseTimeMessage = str;
    }

    public void setResponseTime(long j) {
        this.responseTime = j;
    }

    public void setResponseTimeType(ResponseTimeType responseTimeType2) {
        this.responseTimeType = responseTimeType2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChannelResponseTime{channelId=");
        outline73.append(this.channelId);
        outline73.append(", responseTime=");
        outline73.append(this.responseTime);
        outline73.append(", customResponseTimeMessage=");
        return GeneratedOutlineSupport.outline59(outline73, this.customResponseTimeMessage, '}');
    }
}
