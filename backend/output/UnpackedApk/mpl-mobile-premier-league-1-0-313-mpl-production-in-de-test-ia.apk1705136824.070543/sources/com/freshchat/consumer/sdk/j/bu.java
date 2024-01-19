package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;
import java.util.Arrays;

public final class bu implements b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String[] lS;

    public bu(Context context, long j, String[] strArr) {
        this.iI = context;
        this.fk = j;
        this.lS = strArr;
    }

    public Event gy() {
        a b2 = bg.a(EventName.FCEventConversationOpen);
        Channel m = bg.j(this.iI, this.fk);
        if (m != null) {
            b2.a(Property.FCPropertyChannelID, m.getChannelAlias()).a(Property.FCPropertyChannelName, m.getName());
            Conversation n = bg.c(this.iI, m.getId());
            if (n != null) {
                b2.a(Property.FCPropertyConversationID, Long.valueOf(n.getConversationId()));
            }
        }
        if (as.f(this.lS)) {
            b2.a(Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return b2.gz();
    }
}
