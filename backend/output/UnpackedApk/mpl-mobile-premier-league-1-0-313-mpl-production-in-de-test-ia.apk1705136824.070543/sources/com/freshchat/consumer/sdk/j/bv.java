package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bv implements b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ long nV;

    public bv(long j, Context context, long j2) {
        this.nV = j;
        this.iI = context;
        this.fk = j2;
    }

    public Event gy() {
        a a2 = bg.a(EventName.FCEventCsatExpiry).a(Property.FCPropertyConversationID, Long.valueOf(this.nV));
        Channel m = bg.j(this.iI, this.fk);
        if (m != null) {
            a2.a(Property.FCPropertyChannelID, m.getChannelAlias()).a(Property.FCPropertyChannelName, m.getName());
        }
        return a2.gz();
    }
}
