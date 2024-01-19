package com.clevertap.android.sdk.events;

public enum EventGroup {
    REGULAR(""),
    PUSH_NOTIFICATION_VIEWED("-spiky");
    
    public final String httpResource;

    /* access modifiers changed from: public */
    EventGroup(String str) {
        this.httpResource = str;
    }
}
