package com.freshchat.consumer.sdk.beans.config;

import com.google.gson.annotations.SerializedName;

public class CsatConfig {
    @SerializedName("userCsatViewTimer")
    public boolean csatAutoExpire;
    @SerializedName("maximumUserSurveyViewMillis")
    public long csatExpiryInterval;

    public boolean doesCsatAutoExpire() {
        return this.csatAutoExpire;
    }

    public long getCsatExpiryInterval() {
        return this.csatExpiryInterval;
    }

    public void setCsatAutoExpire(boolean z) {
        this.csatAutoExpire = z;
    }

    public void setCsatExpiryInterval(long j) {
        this.csatExpiryInterval = j;
    }
}
