package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.j.bg.b;

public final class cu implements b {
    public final /* synthetic */ boolean sP;

    public cu(boolean z) {
        this.sP = z;
    }

    public Event gy() {
        return bg.a(this.sP ? EventName.FCEventShowOriginalClick : EventName.FCEventHideOriginalClick).gz();
    }
}
