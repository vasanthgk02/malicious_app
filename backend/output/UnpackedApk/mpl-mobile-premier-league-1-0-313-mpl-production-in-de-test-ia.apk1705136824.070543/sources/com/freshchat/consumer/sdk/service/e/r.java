package com.freshchat.consumer.sdk.service.e;

public class r implements k {
    public a gA;
    public boolean success;

    public enum a {
        UserNotCreated,
        NoInternet,
        Failed,
        Success
    }

    public r(boolean z, a aVar) {
        this.success = z;
        this.gA = aVar;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
