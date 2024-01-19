package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bm implements b {
    public final /* synthetic */ String jW;

    public bm(String str) {
        this.jW = str;
    }

    public Event gy() {
        return bg.a(EventName.FCEventBotFAQVote).a(Property.FCPropertyBotFAQFeedback, this.jW).gz();
    }
}
