package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bl implements b {
    public final /* synthetic */ String jU;
    public final /* synthetic */ String jV;
    public final /* synthetic */ String lN;

    public bl(String str, String str2, String str3) {
        this.lN = str;
        this.jU = str2;
        this.jV = str3;
    }

    public Event gy() {
        return bg.a(EventName.FCEventBotFAQOpen).a(Property.FCPropertyBotFAQTitle, this.lN).a(Property.FCPropertyBotFAQReferenceId, this.jU).a(Property.FCPropertyBotFAQPlaceholderReferenceId, this.jV).gz();
    }
}
