package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;
import java.util.Arrays;

public final class bt implements b {
    public final /* synthetic */ String[] lS;

    public bt(String[] strArr) {
        this.lS = strArr;
    }

    public Event gy() {
        a b2 = bg.a(EventName.FCEventChannelListOpen);
        if (as.f(this.lS)) {
            b2.a(Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return b2.gz();
    }
}
