package com.freshchat.consumer.sdk.beans.reqres;

public class UploadInboundEventsResponse {
    public boolean success;

    public UploadInboundEventsResponse(boolean z) {
        this.success = z;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
