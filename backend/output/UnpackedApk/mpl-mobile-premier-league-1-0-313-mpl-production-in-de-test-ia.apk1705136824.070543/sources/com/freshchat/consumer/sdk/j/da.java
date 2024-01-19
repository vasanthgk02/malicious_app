package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.j.bg.b;

public final class da implements b {
    public final /* synthetic */ EventName sS;

    public da(EventName eventName) {
        this.sS = eventName;
    }

    public Event gy() {
        return bg.a(this.sS).gz();
    }
}
