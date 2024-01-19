package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.service.e.j;

public class BotFAQFetchRequest implements j {
    public String placeholderReferenceId;
    public String referenceId;

    public BotFAQFetchRequest(String str, String str2) {
        this.referenceId = str;
        this.placeholderReferenceId = str2;
    }

    public String getPlaceholderReferenceId() {
        return this.placeholderReferenceId;
    }

    public String getReferenceId() {
        return this.referenceId;
    }
}
