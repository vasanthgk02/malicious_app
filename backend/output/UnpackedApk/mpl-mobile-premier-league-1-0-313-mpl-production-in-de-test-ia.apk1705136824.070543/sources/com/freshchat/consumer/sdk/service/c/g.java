package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.c.d;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.e;
import com.freshchat.consumer.sdk.service.e.f;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;

public class g extends a<e, k> {
    public static void a(Context context, RemoteConfig remoteConfig, RemoteConfig remoteConfig2) {
        if (remoteConfig != null && remoteConfig2 != null && !remoteConfig.getUserAuthConfig().isJwtAuthEnabled() && remoteConfig2.getUserAuthConfig().isJwtAuthEnabled()) {
            a.aY(context);
        }
    }

    private void b(Context context, RemoteConfig remoteConfig, RemoteConfig remoteConfig2) {
        if ((remoteConfig == null || remoteConfig2 == null || remoteConfig.getAccountConfig().getFcFaqApiVersion() == remoteConfig2.getAccountConfig().getFcFaqApiVersion()) ? false : true) {
            com.freshchat.consumer.sdk.b.e i = com.freshchat.consumer.sdk.b.e.i(context);
            int i2 = ai.rg[remoteConfig2.getAccountConfig().getFcFaqApiVersion().ordinal()];
            if (i2 == 1) {
                i.iL();
                b.a(context, f.a.NORMAL);
            } else if (i2 == 2) {
                new d(context).iR();
                com.freshchat.consumer.sdk.b.e.i(context).iP();
            }
            i.iO();
            a.co(context);
        }
    }

    public boolean a(e eVar) {
        String bz = dw().bz();
        if (as.isEmpty(bz)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = Long.parseLong(bz);
        long remoteConfigFetchInterval = getRefreshIntervals().getRemoteConfigFetchInterval();
        if (!w.ay(getContext())) {
            remoteConfigFetchInterval = Math.max(86400000, remoteConfigFetchInterval);
        }
        return currentTimeMillis - parseLong > remoteConfigFetchInterval;
    }

    public k b(e eVar) {
        boolean z = false;
        try {
            if (!a(eVar)) {
                return new h(false);
            }
            RemoteConfig bD = ap.bD(getContext());
            boolean aZ = ap.aZ(getContext());
            RemoteConfig gg = new com.freshchat.consumer.sdk.e.a(getContext()).gg();
            if (gg != null) {
                ap.a(getContext(), gg);
                a(getContext(), bD, gg);
                b(getContext(), bD, gg);
                z = true;
            }
            if (ap.aZ(getContext())) {
                if (!aZ) {
                    a.cm(getContext());
                }
                dw().bA();
            }
            return new h(z);
        } catch (DeletedException | Exception e2) {
            q.a(e2);
        }
    }
}
