package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.e;
import java.util.List;

public class g extends d<Channel> {
    public Conversation aL;
    public long channelId;
    public final e eT;
    public final c eU;
    public final boolean kQ;

    public g(Context context, boolean z) {
        super(context);
        this.eU = new c(context);
        this.eT = new e(context);
        this.kQ = z;
    }

    public g(Context context, boolean z, long j) {
        this(context, z);
        this.channelId = j;
    }

    /* renamed from: df */
    public Channel getData() {
        Channel channel;
        if (this.kQ) {
            this.eT.fR();
        }
        long j = this.channelId;
        if (j <= 0) {
            List<Channel> cv = this.eU.cv();
            if (cv.isEmpty()) {
                return null;
            }
            channel = cv.get(0);
        } else {
            channel = this.eU.e(j);
        }
        if (channel != null) {
            this.aL = this.eT.f(channel.getId());
        }
        return channel;
    }

    public Conversation dg() {
        return this.aL;
    }
}
