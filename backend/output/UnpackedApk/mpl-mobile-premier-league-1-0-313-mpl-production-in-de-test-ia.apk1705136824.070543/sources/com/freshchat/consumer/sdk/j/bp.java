package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bp implements b {
    public final /* synthetic */ String sN;
    public final /* synthetic */ String sO;

    public bp(String str, String str2) {
        this.sN = str;
        this.sO = str2;
    }

    public Event gy() {
        return bg.a(EventName.FCEventQuickActionSelect).a(Property.FCPropertyQuickActionType, this.sN).a(Property.FCPropertyQuickActionLabel, this.sO).gz();
    }
}
