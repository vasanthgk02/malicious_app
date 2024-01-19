package com.freshchat.consumer.sdk.j;

import android.net.Uri;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bj implements b {
    public final /* synthetic */ Uri iD;

    public bj(Uri uri) {
        this.iD = uri;
    }

    public Event gy() {
        return bg.a(EventName.FCEventLinkTap).a(Property.FCPropertyURL, this.iD.toString()).gz();
    }
}
