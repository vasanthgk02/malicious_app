package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.j.k;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class h extends c<Channel> {
    public Map<Long, Integer> ap;
    public final g av;
    public final e eT;
    public final c eU;
    public final boolean kQ;
    public boolean re;
    public List<String> tags;

    public class a implements Comparator<Channel> {
        public a() {
        }

        /* renamed from: a */
        public int compare(Channel channel, Channel channel2) {
            if (channel == null || channel2 == null) {
                return 0;
            }
            int i = 1;
            if (channel.getLatestOrWelcomeMessage() == null && channel2.getLatestOrWelcomeMessage() == null) {
                if (channel.getPosition() < channel2.getPosition()) {
                    i = -1;
                }
                return i;
            } else if (channel.getLatestOrWelcomeMessage() == null) {
                return -1;
            } else {
                if (channel2.getLatestOrWelcomeMessage() == null) {
                    return 1;
                }
                long createdMillis = channel.getLatestOrWelcomeMessage().getCreatedMillis();
                long createdMillis2 = channel2.getLatestOrWelcomeMessage().getCreatedMillis();
                if (createdMillis > 0 || createdMillis2 > 0) {
                    if (createdMillis > createdMillis2) {
                        i = -1;
                    }
                    return i;
                }
                if (channel.getPosition() < channel2.getPosition()) {
                    i = -1;
                }
                return i;
            }
        }
    }

    public h(Context context, boolean z) {
        super(context);
        this.eU = new c(context);
        this.av = new g(context);
        this.eT = new e(context);
        this.kQ = z;
    }

    public h(Context context, boolean z, List<String> list) {
        this(context, z);
        this.tags = list;
    }

    public List<Channel> dd() {
        if (this.kQ) {
            this.eT.fR();
        }
        List<Channel> a2 = this.eU.a(this.tags, false);
        if (k.isEmpty(a2)) {
            Channel cw = this.eU.cw();
            if (cw != null) {
                a2.add(cw);
                this.re = true;
            }
        } else {
            this.re = false;
        }
        Collections.sort(a2, new a());
        this.ap = this.av.cF();
        return a2;
    }

    public Map<Long, Integer> iT() {
        return this.ap;
    }
}
