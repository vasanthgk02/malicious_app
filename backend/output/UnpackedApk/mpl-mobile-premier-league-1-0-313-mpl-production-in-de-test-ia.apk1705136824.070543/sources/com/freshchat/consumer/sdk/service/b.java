package com.freshchat.consumer.sdk.service;

import com.android.tools.r8.GeneratedOutlineSupport;

public class b<T> {
    public final T data;
    public final Status status;

    public b(Status status2, T t) {
        this.status = status2;
        this.data = t;
    }

    public T getData() {
        return this.data;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Response{Status=");
        outline73.append(this.status);
        outline73.append(", data=");
        outline73.append(this.data);
        outline73.append('}');
        return outline73.toString();
    }
}
