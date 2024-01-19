package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.j.ab.d;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bo implements b {
    public final /* synthetic */ QuickReplyButtonFragment jX;

    public bo(QuickReplyButtonFragment quickReplyButtonFragment) {
        this.jX = quickReplyButtonFragment;
    }

    public Event gy() {
        String json = new ab(new d()).toJson(this.jX);
        a b2 = bg.a(EventName.FCEventDropDownOptionSelect);
        if (as.a(json)) {
            b2.a(Property.FCPropertyOption, json);
        }
        return b2.gz();
    }
}
