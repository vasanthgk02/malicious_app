package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.service.e.af;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;

public class ad extends b<af, k> {
    /* renamed from: a */
    public k b(af afVar) {
        e i = e.i(getContext());
        if (!i.eO()) {
            return new h(true);
        }
        ai.i("FRESHCHAT", "Prefs migration starting now");
        long fP = n.fP();
        i.bo(getContext());
        ai.i("FRESHCHAT", "Prefs migration ended in " + (n.fP() - fP) + "ms");
        return new h(true);
    }
}
