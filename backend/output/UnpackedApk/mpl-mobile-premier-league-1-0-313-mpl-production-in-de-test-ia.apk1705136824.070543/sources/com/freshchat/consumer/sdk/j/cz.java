package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.b;

public final class cz implements b {
    public final /* synthetic */ EventName sQ;
    public final /* synthetic */ String sR;

    public cz(EventName eventName, String str) {
        this.sQ = eventName;
        this.sR = str;
    }

    public Event gy() {
        return bg.a(this.sQ).a(Property.FCPropertyInviteId, this.sR).gz();
    }
}
