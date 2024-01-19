package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bs implements b {
    public final /* synthetic */ String lU;
    public final /* synthetic */ int lV;
    public final /* synthetic */ boolean lW;

    public bs(String str, int i, boolean z) {
        this.lU = str;
        this.lV = i;
        this.lW = z;
    }

    public Event gy() {
        return bg.a(EventName.FCEventFAQSearch).a(Property.FCPropertySearchKey, this.lU).a(Property.FCPropertySearchFAQCount, Integer.valueOf(this.lV)).a(Property.FCPropertyIsRelevant, Boolean.valueOf(this.lW)).gz();
    }
}
