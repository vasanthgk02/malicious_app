package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bx implements b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;

    public bx(Context context, long j) {
        this.iI = context;
        this.fk = j;
    }

    public Event gy() {
        a b2 = bg.a(EventName.FCEventCsatOpen);
        Channel m = bg.j(this.iI, this.fk);
        if (m != null) {
            b2.a(Property.FCPropertyChannelID, m.getChannelAlias()).a(Property.FCPropertyChannelName, m.getName());
            Conversation n = bg.c(this.iI, this.fk);
            if (n != null) {
                b2.a(Property.FCPropertyConversationID, Long.valueOf(n.getConversationId()));
            }
        }
        return b2.gz();
    }
}
