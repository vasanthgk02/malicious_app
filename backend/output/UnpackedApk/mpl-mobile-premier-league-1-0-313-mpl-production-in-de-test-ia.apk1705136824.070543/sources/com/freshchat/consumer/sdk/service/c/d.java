package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.b;
import com.freshchat.consumer.sdk.service.e.b.a;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.z;

public class d extends a<b, k> {
    private long a(a aVar) {
        if (aVar == a.IMMEDIATE) {
            return 0;
        }
        if (aVar == a.NORMAL) {
            return getRefreshIntervals().getChannelsFetchIntervalNormal();
        }
        if (aVar == a.LAID_BACK) {
            return getRefreshIntervals().getChannelsFetchIntervalLaidback();
        }
        return 0;
    }

    /* renamed from: a */
    public k b(b bVar) {
        if (!b(bVar)) {
            return new h(false);
        }
        if (com.freshchat.consumer.sdk.service.d.a.v(getContext())) {
            com.freshchat.consumer.sdk.j.b.a(getContext(), z.a.CHANNEL_ICONS);
        }
        return new h(true);
    }

    public boolean b(b bVar) {
        if (!w.ay(getContext()) || !w.aA(getContext())) {
            return false;
        }
        if (ah.aP(getContext())) {
            return true;
        }
        String bG = dw().bG();
        if (as.isEmpty(bG)) {
            return true;
        }
        return System.currentTimeMillis() - Long.parseLong(bG) > a(bVar.dC());
    }
}
