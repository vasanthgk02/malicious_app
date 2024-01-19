package com.freshchat.consumer.sdk.service.e;

import com.freshchat.consumer.sdk.FreshchatCallbackStatus;

public class w implements k {
    public int count = 0;
    public FreshchatCallbackStatus gI;
    public boolean success;

    public void a(FreshchatCallbackStatus freshchatCallbackStatus) {
        this.gI = freshchatCallbackStatus;
    }

    public FreshchatCallbackStatus dO() {
        return this.gI;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
