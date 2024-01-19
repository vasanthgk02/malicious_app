package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.config.RefreshIntervals;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.j.y;
import com.freshchat.consumer.sdk.service.d.e;
import com.freshchat.consumer.sdk.service.e.f;
import com.freshchat.consumer.sdk.service.e.f.a;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.z;

public class h extends a<f, k> {
    private long a(a aVar) {
        RefreshIntervals refreshIntervals = ap.bD(getContext()).getRefreshIntervals();
        if (aVar == a.NORMAL) {
            return refreshIntervals.getFaqFetchIntervalNormal();
        }
        if (aVar == a.LAID_BACK) {
            return refreshIntervals.getFaqFetchIntervalLaidback();
        }
        return 0;
    }

    /* renamed from: a */
    public k b(f fVar) {
        if (b(fVar) ? e.x(getContext()) : false) {
            com.freshchat.consumer.sdk.b.a.h(getContext());
            b.a(getContext(), z.a.FAQ_ICONS);
        }
        return new com.freshchat.consumer.sdk.service.e.h(true);
    }

    public boolean b(f fVar) {
        if (!w.ay(getContext()) || !w.az(getContext()) || y.cp(getContext())) {
            return false;
        }
        if (ah.aO(getContext())) {
            return true;
        }
        String br = dw().br();
        if (as.isEmpty(br)) {
            return true;
        }
        return System.currentTimeMillis() - Long.parseLong(br) > a(fVar.dF());
    }
}
