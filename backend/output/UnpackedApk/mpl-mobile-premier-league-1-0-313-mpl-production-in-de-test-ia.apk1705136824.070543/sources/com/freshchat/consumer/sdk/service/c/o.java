package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.p;

public class o extends a<p, k> {
    public boolean a(p pVar) {
        if (!w.ay(getContext())) {
            return false;
        }
        if (dw().bl()) {
            return true;
        }
        ai.d("FRESHCHAT", c.USER_NOT_REGISTERED_HEARTBEAT_NOT_SENT.toString());
        return false;
    }

    public k b(p pVar) {
        boolean z = false;
        try {
            Context context = getContext();
            if (a(pVar) && al.aS(context)) {
                z = new a(context).cW();
            }
        } catch (DeletedException | Exception e2) {
            q.a(e2);
        }
        ai.d("FRESHCHAT", z ? "Registered user heartbeat." : c.USER_HEARTBEAT_NOT_SENT.toString());
        return new h(true);
    }
}
